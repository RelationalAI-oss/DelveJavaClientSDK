package com.relationalai.client.api;

import com.relationalai.client.model.*;
import com.relationalai.infra.UnrecognizedRegionException;

import java.io.IOException;
import java.security.GeneralSecurityException;

public class ManagementConnection extends Connection {
    private RAIInfra infra;
    private RAIRegion region;
    private ClientConfig clientConfig;
    private boolean verifySSL;

    public ManagementConnection() throws UnrecognizedRegionException, GeneralSecurityException, IOException {
        this(Connection.DEFAULT_SCHEME, Connection.DEFAULT_HOST, Connection.DEFAULT_PORT, Connection.DEFAULT_INFRA,
             Connection.DEFAULT_REGION, null, Connection.DEFAULT_VERIFY_SSL);
    }
    public ManagementConnection(
            String scheme,
            String host,
            int port,
            RAIInfra infra,
            RAIRegion region,
            ClientConfig clientConfig,
            boolean verifySSL
    ) throws UnrecognizedRegionException, GeneralSecurityException, IOException {
        super(scheme, host, port);
        this.infra = infra;
        this.region = region;
        this.clientConfig = clientConfig == null ? ClientConfig.loadConfig() : clientConfig;
        this.verifySSL = verifySSL;
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
}
