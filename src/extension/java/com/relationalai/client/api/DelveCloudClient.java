package com.relationalai.client.api;

import com.relationalai.cloudclient.ApiClient;
import com.relationalai.cloudclient.ApiException;
import com.relationalai.cloudclient.api.DefaultApi;
import com.relationalai.cloudclient.model.*;

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

}
