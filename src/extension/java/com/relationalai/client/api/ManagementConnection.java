package com.relationalai.client.api;

import com.relationalai.client.builder.ManagementConnectionArgs;
import com.relationalai.client.model.*;
import com.relationalai.client.ApiException;
import com.relationalai.cloudclient.model.*;
import com.relationalai.infra.UnrecognizedRegionException;

import java.io.IOException;
import java.security.GeneralSecurityException;

public class ManagementConnection extends Connection {
    private RAIInfra infra;
    private RAIRegion region;
    private ClientConfig clientConfig;
    private boolean verifySSL;

    public ManagementConnection() throws UnrecognizedRegionException, GeneralSecurityException, IOException {
        this(new ManagementConnectionArgs(Connection.DEFAULT_SCHEME, Connection.DEFAULT_HOST, Connection.DEFAULT_PORT, Connection.DEFAULT_INFRA,
             Connection.DEFAULT_REGION, null, Connection.DEFAULT_VERIFY_SSL));
    }
    public ManagementConnection(ManagementConnectionArgs mngtConnArgs) throws UnrecognizedRegionException, GeneralSecurityException, IOException {
        super(mngtConnArgs.getScheme(), mngtConnArgs.getHost(), mngtConnArgs.getPort());
        this.infra = mngtConnArgs.getInfra();
        this.region = mngtConnArgs.getRegion();
        this.clientConfig = mngtConnArgs.getClientConfig() == null ? ClientConfig.loadConfig() : mngtConnArgs.getClientConfig();
        this.verifySSL = mngtConnArgs.getVerifySSL();
        this.setCloudClient(new DelveCloudClient(this));
    }

    @Override
    public RAIInfra getInfra() {
        return infra;
    }

    @Override
    public RAIRegion getRegion() {
        return region;
    }

    @Override
    public ClientConfig getClientConfig() {
        return clientConfig;
    }

    @Override
    public boolean isVerifySSL() {
        return verifySSL;
    }

    private ApiException convert(com.relationalai.cloudclient.ApiException e) {
        return new ApiException(e.getMessage(), e, e.getCode(), e.getResponseHeaders(), e.getResponseBody());
    }

    public ListComputesResponseProtocol listComputes() throws ApiException {
        setConnectionOnClient();
        try {
            return cloudClient.listComputes();
        } catch (com.relationalai.cloudclient.ApiException e) {
            throw convert(e);
        }
    }

    public ListUsersResponseProtocol listUsers() throws ApiException {
        setConnectionOnClient();
        try {
            return cloudClient.listUsers();
        } catch (com.relationalai.cloudclient.ApiException e) {
            throw convert(e);
        }
    }

    public ListDatabasesResponseProtocol listDatabases() throws ApiException {
        setConnectionOnClient();
        try {
            return cloudClient.listDatabases();
        } catch (com.relationalai.cloudclient.ApiException e) {
            throw convert(e);
        }
    }

    public CreateComputeResponseProtocol createCompute(String displayName, String size, String region) throws ApiException{
        setConnectionOnClient();
        try {
            return cloudClient.createCompute(displayName, size, region);
        } catch (com.relationalai.cloudclient.ApiException e) {
            throw convert(e);
        }
    }
    public CreateUserResponseProtocol createUser(String username) throws ApiException {
        setConnectionOnClient();
        try {
            return cloudClient.createUser(username);
        } catch (com.relationalai.cloudclient.ApiException e) {
            throw convert(e);
        }
    }

    public DeleteComputeResponseProtocol deleteCompute(String computeName) throws ApiException {
        setConnectionOnClient();
        try {
            return cloudClient.deleteCompute(computeName);
        } catch (com.relationalai.cloudclient.ApiException e) {
            throw convert(e);
        }
    }
}
