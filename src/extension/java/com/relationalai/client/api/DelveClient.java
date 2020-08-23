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
import org.slf4j.Logger;

import javax.net.ssl.*;
import java.lang.invoke.MethodHandles;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DelveClient extends DefaultApi{
    static final Logger LOGGER = RaiLogger.getLogger(MethodHandles.lookup().lookupClass());

    public final static String DEFAULT_SERVICE = "transaction";

    Connection conn;
    String service;

    public DelveClient(String dbname) {
        this(dbname, DEFAULT_SERVICE);
    }

    public DelveClient(String dbname, String service) {
        this(new Connection(dbname), service);
    }

    public DelveClient(Connection conn) {
        this(conn, DEFAULT_SERVICE);
    }

    public DelveClient(Connection conn, String service) {
        super();
        this.conn = conn;
        this.service = service;
        ApiClient api = this.getApiClient();
        OkHttpClient client = api.getHttpClient();
        if(!conn.isVerifySSL()) {
            LOGGER.warn("Using the trustAllSslClient is highly discouraged and should not be used in Production!");
            OkHttpClient.Builder builder = client.newBuilder();
            builder.sslSocketFactory(trustAllSslSocketFactory, (X509TrustManager)trustAllCerts[0]);
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
        String localVarPath = "/transaction";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();
//        final String[] localVarAccepts = {
//                "application/json"
//        };
//        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
//        if (localVarAccept != null) {
//            localVarHeaderParams.put("Accept", localVarAccept);
//        }

        final String[] localVarContentTypes = {
                "application/json"
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        localVarHeaderParams.put("Host", conn.getHost());

        String[] localVarAuthNames = new String[] {  };

        localVarApiClient.setBasePath(conn.getBaseUrl());

        Request request = localVarApiClient.buildRequest(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);

        ClientConfig clientConf = conn.getClientConfig();

        if( clientConf != null ) {
            try {
                Http2Client.signRequest(request, clientConf.getAccessKey(), clientConf.getRegionName(), clientConf.getPrivateKeysetHandle(), service);
            } catch (Exception e) {
                throw new ApiException(e);
            }
        }

        return localVarApiClient.getHttpClient().newCall(request);
    }

    public ActionResult run_action(Connection conn, String name, Action action) throws ApiException {
        Transaction xact = new Transaction();
        xact.setMode(Transaction.ModeEnum.OPEN);
        xact.setDbname(conn.getDbname());

        LabeledAction labeledAction = new LabeledAction();
        labeledAction.setName(name);
        labeledAction.setAction(action);
        xact.addActionsItem(labeledAction);

        TransactionResult response = this.transactionPost(xact);

        if (!response.getAborted() && response.getProblems().isEmpty()) {
            for (LabeledActionResult act : response.getActions()) {
                if (name.equals(act.getName())) {
                    ActionResult res = (ActionResult) act.getResult();
                    return res;
                }
            }
        }
        return null;
    }

    public boolean create_database(Connection conn, boolean overwrite) throws ApiException {
        Transaction xact = new Transaction();
        xact.setMode(overwrite ? Transaction.ModeEnum.CREATE_OVERWRITE : Transaction.ModeEnum.CREATE);
        xact.setDbname(conn.getDbname());
        TransactionResult response = this.transactionPost(xact);

        return !response.getAborted() && response.getProblems().isEmpty();
    }

    public InstallActionResult install_source(Connection conn, String name, String path, String src_str) throws ApiException {
        Source src = new Source();
        src.setName(name);
        src.setPath(path);
        src.setValue(src_str);

        InstallAction action = new InstallAction();
        action.addSourcesItem(src);

        return (InstallActionResult) run_action(conn, "single", action);
    }

    public QueryActionResult query(Connection conn, String name, String path, String src_str, String out) throws ApiException {
        Source src = new Source();
        src.setName(name);
        src.setPath(path);
        src.setValue(src_str);

        QueryAction action = new QueryAction();
        action.setSource(src);
        action.addOutputsItem(out);

        return (QueryActionResult) run_action(conn, "single", action);
    }

    /*
     * This is very bad practice and should NOT be used in production.
     */
    private static final TrustManager[] trustAllCerts = new TrustManager[] {
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
    private static final SSLContext trustAllSslContext;
    static {
        try {
            trustAllSslContext = SSLContext.getInstance("SSL");
            trustAllSslContext.init(null, trustAllCerts, new java.security.SecureRandom());
        } catch (NoSuchAlgorithmException | KeyManagementException e) {
            throw new RuntimeException(e);
        }
    }
    private static final SSLSocketFactory trustAllSslSocketFactory = trustAllSslContext.getSocketFactory();
}
