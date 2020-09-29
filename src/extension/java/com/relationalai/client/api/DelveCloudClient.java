package com.relationalai.client.api;

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

public class DelveCloudClient extends DefaultApi {

    private Connection conn;

    public DelveCloudClient(){
        super();
    }
    public DelveCloudClient(ApiClient apiClient){
        super(apiClient);
    }

    public DelveCloudClient(Connection connection){
        super(new ApiClient());
        ApiClient apiClient = this.getApiClient();
        this.getApiClient().setBasePath(connection.getBaseUrl());
        this.getApiClient().setVerifyingSsl(connection.isVerifySSL());
    }

    public ListComputesResponseProtocol listComputes() throws ApiException { return this.computeGet(); }
    public ListUsersResponseProtocol listUsers() throws ApiException { return this.userGet(); }
    public ListDatabasesResponseProtocol listDatabases() throws ApiException { return this.databaseGet(); }

    public CreateComputeResponseProtocol createCompute(String displayName, String size, String region) throws ApiException{
        CreateComputeRequestProtocol createComputeRequestProtocol = new CreateComputeRequestProtocol();
        createComputeRequestProtocol.setDisplayName(displayName);
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
        deleteComputeRequestProtocol.setComputeName(computeName);
        deleteComputeRequestProtocol.setDryrun(false);

        return this.computeDelete(deleteComputeRequestProtocol);
    }

    public Connection getConn() { return conn; }

    public void setConn(Connection conn) { this.conn = conn; }

    @Override
    public Call computeGetCall(ApiCallback _callback) throws ApiException{
        return call("/compute",null, "GET", _callback);
    }

    @Override
    public Call userGetCall(ApiCallback _callback) throws ApiException {
        return call("/user", null, "GET", _callback);
    }

    @Override
    public Call databaseGetCall(ApiCallback _callback) throws ApiException {
        return call("/database", null, "GET", _callback);
    }

    @Override
    public Call computePutCall(CreateComputeRequestProtocol createComputeRequestProtocol, ApiCallback _callback) throws ApiException {
        return call("/compute", createComputeRequestProtocol, "PUT", _callback);
    }

    @Override
    public Call userPutCall(CreateUserRequestProtocol createUserRequestProtocol, ApiCallback _callback) throws ApiException {
        return call("/user", null, "PUT", _callback);
    }

    @Override
    public Call computeDeleteCall(DeleteComputeRequestProtocol deleteComputeRequestProtocol, ApiCallback _callback) throws ApiException {
        return call("/compute", deleteComputeRequestProtocol, "DELETE", _callback);
    }

    private Call call(String path, Object body, String method, ApiCallback _callback) throws ApiException {
        Object localVarPostBody = body;
        String localVarPath = path;

        ApiClient localVarApiClient = getApiClient();

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
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
