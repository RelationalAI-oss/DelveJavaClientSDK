package com.relationalai.client.api;

import com.relationalai.client.ApiCallback;
import com.relationalai.client.ApiClient;
import com.relationalai.client.ApiException;
import com.relationalai.client.Pair;
import com.relationalai.client.model.*;
import com.relationalai.util.RaiLogger;
import com.relationalai.util.http.Http2Client;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;

import javax.net.ssl.*;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.*;

public class DelveClient extends DefaultApi {
    public final static boolean ENABLE_ACCEPT_HEADER = false;
    public final static String DEFAULT_SERVICE = "transaction";
    public final static String DEFAULT_SERVICE_PATH = "/" + DEFAULT_SERVICE;
    public final String JSON_CONTENT_TYPE = "application/json";
    public final String CSV_CONTENT_TYPE = "text/csv";

    static final Logger LOGGER = RaiLogger.getLogger(MethodHandles.lookup().lookupClass());
    /*
     * This is very bad practice and should NOT be used in production.
     */
    static final TrustManager[] trustAllCerts = new TrustManager[]{
        new X509TrustManager() {
            @Override
            public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {
            }

            @Override
            public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {
            }

            @Override
            public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                return new java.security.cert.X509Certificate[]{};
            }
        }
    };
    static final SSLContext trustAllSslContext;

    static {
        try {
            trustAllSslContext = SSLContext.getInstance("SSL");
            trustAllSslContext.init(null, trustAllCerts, new java.security.SecureRandom());
        } catch (NoSuchAlgorithmException | KeyManagementException e) {
            throw new RuntimeException(e);
        }
    }
    private static final SSLSocketFactory trustAllSslSocketFactory = trustAllSslContext.getSocketFactory();
    private static ApiClient defaultApiClient = new ExtendedApiClient();

    Connection conn;
    String service;

    public DelveClient(Connection conn) {
        this(conn, DEFAULT_SERVICE);
    }

    public DelveClient(Connection conn, String service) {
        super(defaultApiClient);
        this.conn = conn;
        this.service = service;
        ApiClient api = this.getApiClient();
        OkHttpClient client = api.getHttpClient();
        if (!conn.isVerifySSL()) {
            LOGGER.warn("Using the trustAllSslClient is highly discouraged and should not be used in Production!");
            OkHttpClient.Builder builder = client.newBuilder();
            builder.sslSocketFactory(trustAllSslSocketFactory, (X509TrustManager) trustAllCerts[0]);
            builder.hostnameVerifier(new HostnameVerifier() {
                @Override
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            });
            api.setHttpClient(builder.build());
        }
    }

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    public okhttp3.Call transactionPostCall(Transaction transaction, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = transaction;

        ApiClient localVarApiClient = getApiClient();

        // create path and map variables
        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        // The following section determines the `Accept` HTTP header, but we had to disable
        // it for now, as the authentication mechanism on the infra side complains if any
        // header other than `Host` and `Content-Type` is available. We can re-enable this
        if (ENABLE_ACCEPT_HEADER) {
            final String[] localVarAccepts = {
                    "application/json"
            };
            final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
            if (localVarAccept != null) {
                localVarHeaderParams.put("Accept", localVarAccept);
            }
        }

        if (conn instanceof CloudConnection) {
            localVarQueryParams.add(new Pair("dbname", conn.getDbName()));
            localVarQueryParams.add(new Pair("open_mode", transaction.getMode().toString()));
            localVarQueryParams.add(new Pair("readonly", transaction.getReadonly() ? "true" : "false"));
            localVarQueryParams.add(new Pair("empty", transaction.getActions() == null || transaction.getActions().isEmpty() ? "true" : "false"));
            localVarQueryParams.add(new Pair("region", conn.getClientConfig().getRegionName()));
            localVarQueryParams.add(new Pair("compute_name", conn.getComputeName()));
        }

        final String[] localVarContentTypes = {
                "application/json; charset=utf-8"
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        localVarHeaderParams.put("Host", conn.getHost());

        String[] localVarAuthNames = new String[]{};

        localVarApiClient.setBasePath(conn.getBaseUrl());

        Request request = localVarApiClient.buildRequest(DEFAULT_SERVICE_PATH, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);

        // Do not sign requests on the LocalConnection
        if( conn instanceof ManagementConnection || conn instanceof CloudConnection) {
            ClientConfig clientConf = conn.getClientConfig();

            if (clientConf != null) {
                try {
                    request = Http2Client.signRequest(request, clientConf.getAccessKey(), clientConf.getRegionName(), clientConf.getPrivateKeysetHandle(), service);
                } catch (Exception e) {
                    throw new ApiException(e);
                }
            }
        }

        return localVarApiClient.getHttpClient().newCall(request);
    }

    public ActionResult runAction(Connection conn, String name, Action action, boolean isReadOnly, Transaction.ModeEnum mode) throws ApiException {
        Transaction xact = new Transaction();
        xact.setMode(mode);
        xact.setDbname(conn.getDbName());
        xact.setReadonly(isReadOnly);

        LabeledAction labeledAction = new LabeledAction();
        labeledAction.setName(name);
        labeledAction.setAction(action);
        xact.addActionsItem(labeledAction);

        TransactionResult response = this.transactionPost(xact);

        if (!response.getAborted() && response.getProblems().isEmpty()) {
            for (LabeledActionResult act : response.getActions()) {
                if (name.equals(act.getName())) {
                    ActionResult res = act.getResult();
                    return res;
                }
            }
        }
        return null;
    }

    public ActionResult runAction(Connection conn, String name, Action action) throws ApiException {
        return runAction(conn, name, action, false, Transaction.ModeEnum.OPEN);
    }

    public boolean createDatabase(boolean overwrite) throws ApiException {
        Transaction xact = new Transaction();
        xact.setMode(overwrite ? Transaction.ModeEnum.CREATE_OVERWRITE : Transaction.ModeEnum.CREATE);
        xact.setDbname(conn.getDbName());
        xact.setActions(Collections.emptyList());

        TransactionResult response = this.transactionPost(xact);

        if(!response.getProblems().isEmpty()) {
            throw new RuntimeException(response.getProblems().toString());
        }

        return !response.getAborted();
    }

    public boolean branchDatabase(String sourceName) throws ApiException {
        Transaction xact = new Transaction();
        xact.setMode(Transaction.ModeEnum.BRANCH);
        xact.setDbname(conn.getDbName());
        xact.setActions(new ArrayList<LabeledAction>());
        xact.setSourceDbname(sourceName);
        xact.setReadonly(false);
        TransactionResult response = this.transactionPost(xact);

        if(!response.getProblems().isEmpty()) {
            throw new RuntimeException(response.getProblems().toString());
        }

        return !response.getAborted();
    }

    public boolean installSource(String name, String path, String srcStr) throws ApiException, IOException {
        Source src = new Source();
        src.setName(name);
        src.setPath(path);
        src.setValue(srcStr);

        return installSource(src);
    }

    public boolean installSource(Source src) throws IOException, ApiException {
        return installSource(Arrays.asList(src));
    }

    public boolean installSource(List<Source> srcList) throws ApiException, IOException {
        InstallAction action = new InstallAction();
        for(Source src : srcList) {
            _readFileFromPath(src);
        }
        action.setSources(srcList);
        return runAction(conn, "single", action, false, Transaction.ModeEnum.OPEN) != null;
    }

    public QueryActionResult query(
            Source src,
            List<Relation> inputs,
            List<String> outputs,
            List<String> persist,
            boolean isReadOnly,
            Transaction.ModeEnum mode
    ) throws ApiException {
        if (src == null) {
            src = new Source();
            src.setName("");
            src.setPath("");
            src.setValue("");
        }
        if (inputs == null)
            inputs = new ArrayList<Relation>();
        if (outputs == null)
            outputs = new ArrayList<String>();
        if (persist == null)
            persist = new ArrayList<String>();

        QueryAction action = new QueryAction();
        action.setInputs(inputs);
        action.setSource(src);
        action.setOutputs(outputs);
        action.setPersist(persist);

        return (QueryActionResult) runAction(conn, "single", action, isReadOnly, mode);
    }

    public QueryActionResult query(
            String name,
            String path,
            String srcStr,
            List<Relation> inputs,
            List<String> outputs,
            List<String> persist,
            boolean isReadOnly,
            Transaction.ModeEnum mode
    ) throws ApiException {
        if (path == null) path = name;
        Source src = new Source();
        src.setName(name);
        src.setPath(path);
        src.setValue(srcStr);
        return query(src, inputs, outputs, persist, isReadOnly, mode);
    }

    public QueryActionResult query(String name, String path, String src_str, String out) throws ApiException {
        Source src = new Source();
        src.setName(name);
        src.setPath(path);
        src.setValue(src_str);

        return query(src, new ArrayList<Relation>(), Arrays.asList(out), new ArrayList<>(), false, Transaction.ModeEnum.OPEN);
    }

    public boolean deleteSource(List<String> scrNameList) throws ApiException {
        ModifyWorkspaceAction action = new ModifyWorkspaceAction();
        action.setDeleteSource(scrNameList);

        return runAction(conn, "single", action) != null;
    }

    public boolean deleteSource(String srcName) throws ApiException {
        return deleteSource(Arrays.asList(srcName));
    }

    public Map<String, Source> listSource() throws ApiException {
        ListSourceAction action = new ListSourceAction();
        ListSourceActionResult actionRes = (ListSourceActionResult) runAction(conn, "single", action);

        Map resultDict = new HashMap<String, Source>();
        for(Source src : actionRes.getSources()) {
            resultDict.put(src.getName(), src);
        }

        return resultDict;
    }

    // TODO
    public void updateEdb(){}

    public LoadData jsonString(String data, Object key, FileSyntax syntax, FileSchema schema) {
        LoadData loadData = new LoadData();
        loadData.setData(data);
        loadData.setContentType(JSON_CONTENT_TYPE);
        loadData.setKey(key);
        loadData.setFileSyntax(syntax);
        loadData.setFileSchema(schema);

        return loadData;
    }

    public LoadData jsonFile(String filePath, Object key, FileSyntax syntax, FileSchema schema) {
        LoadData loadData = new LoadData();
        loadData.setPath(filePath);
        loadData.setContentType(JSON_CONTENT_TYPE);
        loadData.setKey(key);
        loadData.setFileSyntax(syntax);
        loadData.setFileSchema(schema);

        return loadData;
    }

    public LoadData csvString(String data, Object key, FileSyntax syntax, FileSchema schema) {
        LoadData loadData = new LoadData();
        loadData.setData(data);
        loadData.setContentType(CSV_CONTENT_TYPE);
        loadData.setKey(key);
        loadData.setFileSyntax(syntax);
        loadData.setFileSchema(schema);

        return loadData;
    }

    public LoadData csvFile(String filePath, Object key, FileSyntax syntax, FileSchema schema) {
        LoadData loadData = new LoadData();
        loadData.setPath(filePath);
        loadData.setContentType(CSV_CONTENT_TYPE);
        loadData.setKey(key);
        loadData.setFileSyntax(syntax);
        loadData.setFileSchema(schema);

        return loadData;
    }

    private void _handleNullFieldsForLoadData(LoadData loadData) {
        if (!StringUtils.isEmpty(loadData.getData()) && !StringUtils.isEmpty(loadData.getPath())) {
            String message = String.format(
                    "Either `Path` or `Data` should be specified for `LoadData`." +
                    "You have provided both: `Path`=%s and `Data`=%s", loadData.getPath(), loadData.getData());
            throw new IllegalArgumentException(message);
        }

        if (StringUtils.isEmpty(loadData.getPath()) && StringUtils.isEmpty(loadData.getData())) {
            throw new IllegalArgumentException("Either `Path` or `Data` is required.");
        }

        if (StringUtils.isEmpty(loadData.getContentType())) {
            throw new IllegalArgumentException("`ContentType` is required.");
        }

        if (!loadData.getContentType().startsWith(JSON_CONTENT_TYPE) && !loadData.getContentType().startsWith(CSV_CONTENT_TYPE)) {
            throw new IllegalArgumentException(String.format("`ContentType`=%s is not supported.", loadData.getContentType()));
        }
    }

    private void _readFileFromPath(LoadData loadData) throws IOException {
        if (!StringUtils.isEmpty(loadData.getPath()) && StringUtils.isEmpty(loadData.getData())) {
            Path filePath = Paths.get(loadData.getPath());
            if (Files.exists(filePath)) {
                loadData.setData(Files.readString(filePath));
                loadData.setPath(null);
            }
        }
    }

    private void _readFileFromPath(Source src) throws IOException {
        if (!StringUtils.isEmpty(src.getPath())) {
            Path filePath = Paths.get(src.getPath());
            if (StringUtils.isEmpty(src.getName())) {
                src.setName(filePath.getFileName().toString());
            }
            if (StringUtils.isEmpty(src.getValue()) && Files.exists(filePath)) {
                src.setValue(Files.readString(filePath));
            }
        }
    }

    public boolean loadEdb(String rel, LoadData value) throws IOException, ApiException {
        _handleNullFieldsForLoadData(value);
        _readFileFromPath(value);
        LoadDataAction action = new LoadDataAction();
        action.setRel(rel);
        action.setValue(value);

        return runAction(conn, "single", action) != null;
    }

    public boolean loadEdb(
            String rel,
            String contentType,
            String data,
            String path,
            Object key,
            FileSyntax syntax,
            FileSchema schema
    ) throws IOException, ApiException {
        if (key == null) key = new ArrayList();

        LoadData loadData = new LoadData();
        loadData.setContentType(contentType);
        loadData.setData(data);
        loadData.setPath(path);
        loadData.setKey(key);
        loadData.setFileSyntax(syntax);
        loadData.setFileSchema(schema);

        return loadEdb(rel, loadData);
    }

    public boolean loadCSV(
            String rel,
            String data,
            String path,
            Object key,
            FileSyntax syntax,
            FileSchema schema
    ) throws IOException, ApiException {
        return loadEdb(rel, CSV_CONTENT_TYPE, data, path, key, syntax, schema);
    }

    public boolean loadJSON(
            String rel,
            String data,
            String path,
            Object key
    ) throws IOException, ApiException {
        return loadEdb(rel, JSON_CONTENT_TYPE, data, path, key, new JSONFileSyntax(), new JSONFileSchema());
    }

    public List<RelKey> listEdb(String relName) throws ApiException {
        ListEdbAction action = new ListEdbAction();
        if (relName != null) action.setRelname(relName);
        ListEdbActionResult actionRes = (ListEdbActionResult) runAction(conn, "single", action);
        return actionRes.getRels();
    }

    public List<RelKey> deleteEdb(String relName) throws ApiException {
        ModifyWorkspaceAction action = new ModifyWorkspaceAction();
        action.setDeleteEdb(relName);
        ModifyWorkspaceActionResult actionRes = (ModifyWorkspaceActionResult) runAction(conn, "single", action);
        return actionRes.getDeleteEdbResult();
    }

    public boolean enableLibrary(String srcName) throws ApiException {
        ModifyWorkspaceAction action = new ModifyWorkspaceAction();
        action.setEnableLibrary(srcName);
        return runAction(conn, "single", action) != null;
    }

    public List<Relation> cardinality(String relName) throws ApiException {
        CardinalityAction action = new CardinalityAction();
        if (relName != null) action.setRelname(relName);
        return ((CardinalityActionResult) runAction(conn, "single", action)).getResult();
    }

    public List<AbstractProblem> collectProblems(String relName) throws ApiException {
        CardinalityAction action = new CardinalityAction();
        if (relName != null) action.setRelname(relName);
        CollectProblemsActionResult actionRes = (CollectProblemsActionResult) runAction(conn, "single", action);
        return actionRes.getProblems();
    }

    public boolean configure(
            boolean debug,
            boolean debugTrace,
            boolean broken,
            boolean silent,
            boolean abortOnError
    ) throws ApiException {
        SetOptionsAction action = new SetOptionsAction();
        action.setDebug(debug);
        action.setDebugTrace(debugTrace);
        action.setBroken(broken);
        action.setSilent(silent);
        action.setAbortOnError(abortOnError);
        return runAction(conn, "single", action) != null;
    }
}
