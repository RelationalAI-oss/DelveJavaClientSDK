package com.relationalai.client.api;

import com.relationalai.client.model.RAIComputeFilters;
import com.relationalai.client.model.RAIDatabaseFilters;
import com.relationalai.cloudclient.ApiCallback;
import com.relationalai.cloudclient.ApiClient;
import com.relationalai.cloudclient.ApiException;
import com.relationalai.cloudclient.Pair;
import com.relationalai.cloudclient.api.DefaultApi;
import com.relationalai.cloudclient.model.*;
import com.relationalai.util.http.Http2Client;
import okhttp3.Call;
import okhttp3.Request;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DelveCloudClient extends DefaultApi {

    private Connection conn;
    public final int DEFAULT_TIMEOUT = 5 * 60 * 1000;// 5 mins

    public DelveCloudClient(){
        super();
    }
    public DelveCloudClient(ApiClient apiClient){
        super(apiClient);
    }

    public DelveCloudClient(Connection connection, int connectionTimeOut){
        super(new ApiClient());

        int timeout = connectionTimeOut == -1 ? DEFAULT_TIMEOUT : connectionTimeOut;

        this.getApiClient().setConnectTimeout(timeout);
        this.getApiClient().setWriteTimeout(timeout);
        this.getApiClient().setReadTimeout(timeout);

        this.getApiClient().setBasePath(connection.getBaseUrl());
        this.getApiClient().setVerifyingSsl(connection.isVerifySSL());
    }

    public DelveCloudClient(Connection connection) {
        this(connection, -1);
    }

    public ListComputesResponseProtocol listComputes() throws ApiException { return this.computeGet(null, null, null, null); }
    public ListComputesResponseProtocol listComputes(RAIComputeFilters filters) throws ApiException {
        List<String> sizes = null;
        if (filters.size != null) {
            sizes = filters.size.stream().map(Enum::toString).collect(Collectors.toList());
        }
        return this.computeGet(filters.id, filters.name, sizes, filters.state);
    }
    public ListUsersResponseProtocol listUsers() throws ApiException { return this.userGet(); }
    public ListDatabasesResponseProtocol listDatabases() throws ApiException { return this.databaseGet(null, null, null); }
    public ListDatabasesResponseProtocol listDatabases(RAIDatabaseFilters filters) throws ApiException {
        return this.databaseGet(filters.id, filters.name, filters.state); 
    }

    public CreateComputeResponseProtocol createCompute(String name, String size) throws ApiException {
        return createCompute(name, size, conn.getRegion().getName());
    }
    public CreateComputeResponseProtocol createCompute(String name, String size, String region) throws ApiException{
        CreateComputeRequestProtocol createComputeRequestProtocol = new CreateComputeRequestProtocol();
        createComputeRequestProtocol.setName(name);
        createComputeRequestProtocol.setSize(size);
        createComputeRequestProtocol.setRegion(region);
        createComputeRequestProtocol.setDryrun(false);

        return this.computePut(createComputeRequestProtocol);
    }
    public CreateUserResponseProtocol createUser(String username) throws ApiException {
        CreateUserRequestProtocol createUserRequestProtocol = new CreateUserRequestProtocol();
        createUserRequestProtocol.setUsername(username);
        createUserRequestProtocol.dryrun(false);

        return this.userPut(createUserRequestProtocol);
    }

    public DeleteComputeResponseProtocol deleteCompute(String computeName) throws ApiException {
        DeleteComputeRequestProtocol deleteComputeRequestProtocol = new DeleteComputeRequestProtocol();
        deleteComputeRequestProtocol.setName(computeName);
        deleteComputeRequestProtocol.setDryrun(false);

        return this.computeDelete(deleteComputeRequestProtocol);
    }

    public void removeDefaultCompute(String dbName) throws ApiException {
        UpdateDatabaseRequestProtocol updateDatabaseRequestProtocol = new UpdateDatabaseRequestProtocol();
        updateDatabaseRequestProtocol.setName(dbName);
        updateDatabaseRequestProtocol.removeDefaultCompute(true);
        updateDatabaseRequestProtocol.dryrun(false);

        this.databasePost(updateDatabaseRequestProtocol);
    }

    public ListComputeEventsResponse listComputeEvents(String computeId) throws ApiException {
        return super.listComputeEvents(computeId);
    }

    public enum Period {
        CURRENT_MONTH {
            public String toString() {
                return "current_month";
            }
        },
        PREVIOUS_MONTH {
            public String toString() {
                return "previous_month";
            }
        }
    }


    public GetAccountCreditsResponse getAccountCredits() throws ApiException { return this.getAccountCredits(Period.CURRENT_MONTH); }
    public GetAccountCreditsResponse getAccountCredits(Period period) throws ApiException {
        return this.accountCreditsGet(period.toString());
    }

    public Connection getConn() { return conn; }

    public void setConn(Connection conn) { this.conn = conn; }

    @Override
    public Call computeGetCall(List<String> id, List<String> name, List<String> size, List<String> state, ApiCallback _callback) throws ApiException{
        ApiClient localVarApiClient = getApiClient();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (id != null) {
            localVarCollectionQueryParams.addAll(localVarApiClient.parameterToPairs("multi", "id", id));
        }

        if (name != null) {
            localVarCollectionQueryParams.addAll(localVarApiClient.parameterToPairs("multi", "name", name));
        }

        if (size != null) {
            localVarCollectionQueryParams.addAll(localVarApiClient.parameterToPairs("multi", "size", size));
        }

        if (state != null) {
            localVarCollectionQueryParams.addAll(localVarApiClient.parameterToPairs("multi", "state", state));
        }

        return call("/compute",null, "GET", localVarCollectionQueryParams, _callback);
    }

    @Override
    public Call userGetCall(ApiCallback _callback) throws ApiException {
        return call("/user", null, "GET", null, _callback);
    }

    @Override
    public Call databaseGetCall(List<String> id, List<String> name, List<String> state, ApiCallback _callback) throws ApiException {
        ApiClient localVarApiClient = getApiClient();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (id != null) {
            localVarCollectionQueryParams.addAll(localVarApiClient.parameterToPairs("multi", "id", id));
        }

        if (name != null) {
            localVarCollectionQueryParams.addAll(localVarApiClient.parameterToPairs("multi", "name", name));
        }

        if (state != null) {
            localVarCollectionQueryParams.addAll(localVarApiClient.parameterToPairs("multi", "state", state));
        }

        return call("/database",null, "GET", localVarCollectionQueryParams, _callback);
    }

    @Override
    public Call computePutCall(CreateComputeRequestProtocol createComputeRequestProtocol, ApiCallback _callback) throws ApiException {
        return call("/compute", createComputeRequestProtocol, "PUT", null, _callback);
    }

    @Override
    public Call userPutCall(CreateUserRequestProtocol createUserRequestProtocol, ApiCallback _callback) throws ApiException {
        return call("/user", null, "PUT", null, _callback);
    }

    @Override
    public Call computeDeleteCall(DeleteComputeRequestProtocol deleteComputeRequestProtocol, ApiCallback _callback) throws ApiException {
        return call("/compute", deleteComputeRequestProtocol, "DELETE", null, _callback);
    }

    @Override
    public Call databasePostCall(UpdateDatabaseRequestProtocol updateDatabaseRequestProtocol, ApiCallback _callback) throws ApiException {
        return call("/database", updateDatabaseRequestProtocol, "POST", null, _callback);
    }

    private Call call(
        String path, Object body, String method, List<Pair> collectionQueryParams, ApiCallback _callback) throws ApiException {
        Object localVarPostBody = body;
        String localVarPath = path;

        ApiClient localVarApiClient = getApiClient();

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = collectionQueryParams == null ? new ArrayList<Pair>() : collectionQueryParams;
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarContentTypes = {
                "application/json; charset=utf-8"
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        localVarHeaderParams.put("Host", conn.getHost());
        String[] localVarAuthNames = new String[] {  };

        Request request = localVarApiClient.buildRequest(localVarPath, method, localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);

        if( conn instanceof ManagementConnection || conn instanceof CloudConnection) {
            ClientConfig clientConf = conn.getClientConfig();

            if (clientConf != null) {
                try {
                    request = Http2Client.signRequest(request, clientConf.getAccessKey(), clientConf.getRegionName(), clientConf.getPrivateKeysetHandle(), localVarPath.substring(1));
                } catch (Exception e) {
                    e.printStackTrace();
                    throw new ApiException(e);
                }
            }
        }

        return localVarApiClient.getHttpClient().newCall(request);
    }
}
