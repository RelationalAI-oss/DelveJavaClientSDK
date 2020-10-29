package com.relationalai.client.api;

import com.relationalai.client.builder.ManagementConnectionArgs;
import com.relationalai.client.model.*;
import com.relationalai.client.ApiException;
import com.relationalai.cloudclient.model.*;
import com.relationalai.infra.UnrecognizedRegionException;
import com.relationalai.infra.config.InfraMetadataConfig;

import java.io.IOException;
import java.security.GeneralSecurityException;

public class ManagementConnection extends Connection {
    private InfraMetadataConfig.Infra infra;
    private InfraMetadataConfig.RaiRegion region;
    private ClientConfig clientConfig;
    private boolean verifySSL;

    public ManagementConnection() throws UnrecognizedRegionException, GeneralSecurityException, IOException {
        this(new ManagementConnectionArgs(
            Connection.DEFAULT_SCHEME,
            Connection.DEFAULT_HOST,
            Connection.DEFAULT_PORT,
            Connection.DEFAULT_INFRA,
            Connection.DEFAULT_REGION,
            null,
            Connection.DEFAULT_VERIFY_SSL
        ));
    }

    public ManagementConnection(String scheme, Boolean isVerifySSL, ClientConfig clientConfig) throws UnrecognizedRegionException, GeneralSecurityException, IOException {
        this(new ManagementConnectionArgs(
            scheme,
            clientConfig._raiHost,
            clientConfig._raiPort,
            clientConfig._infra,
            clientConfig._region,
            clientConfig,
            isVerifySSL
        ));
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
    public InfraMetadataConfig.Infra getInfra() {
        return infra;
    }

    @Override
    public InfraMetadataConfig.RaiRegion getRegion() {
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

    @Override
    public Transaction.ModeEnum getDefaultOpenMode() { return Transaction.ModeEnum.OPEN; }

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

    public ListComputesResponseProtocol listComputes(RAIComputeFilters filters) throws ApiException {
        setConnectionOnClient();
        try {
            return cloudClient.listComputes(filters);
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

    public CreateComputeResponseProtocol createCompute(String displayName, RaiComputeSize size) throws ApiException {
        setConnectionOnClient();
        try {
            return cloudClient.createCompute(displayName, size.toString());
        } catch (com.relationalai.cloudclient.ApiException e) {
            throw  convert(e);
        }
    }

    public CreateComputeResponseProtocol createCompute(String displayName, RaiComputeSize size, InfraMetadataConfig.RaiRegion region) throws ApiException{
        setConnectionOnClient();
        try {
            return cloudClient.createCompute(displayName, size.toString(), region.getName());
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

    public void removeDefaultCompute(String dbName) throws ApiException {
        setConnectionOnClient();
        try {
            cloudClient.removeDefaultCompute(dbName);
        } catch (com.relationalai.cloudclient.ApiException e) {
            throw convert(e);
        }
    }
}
