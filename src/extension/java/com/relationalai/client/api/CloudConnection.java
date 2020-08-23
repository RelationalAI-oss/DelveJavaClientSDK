package com.relationalai.client.api;

import com.relationalai.client.model.Transaction;

public class CloudConnection extends Connection{
    private ClientConfig clientConfig;
    private boolean verifySSL;
    private String computeName;

    public CloudConnection(String dbname, String computeName) throws Exception {
        super(dbname);
        this.clientConfig = ClientConfig.loadConfig(ClientConfig.getDefaultConfigDir(), ClientConfig.DEFAULT_PROFILE_NAME);
        this.verifySSL = Connection.DEFAULT_VERIFY_SSL;
        this.computeName = computeName;
    }

    public CloudConnection(Connection conn, ClientConfig clientConfig, boolean verifySSL, String computeName) {
        super(conn);
        this.clientConfig = clientConfig;
        this.verifySSL = verifySSL;
        this.computeName = computeName;
    }

    public CloudConnection(String dbname, Transaction.ModeEnum defaultOpenMode, String scheme, String host, int port, ClientConfig clientConfig, boolean verifySSL, String computeName) {
        super(dbname, defaultOpenMode, scheme, host, port);
        this.clientConfig = clientConfig;
        this.verifySSL = verifySSL;
        this.computeName = computeName;
    }

    public ClientConfig getClientConfig() {
        return clientConfig;
    }

    public void setClientConfig(ClientConfig clientConfig) {
        this.clientConfig = clientConfig;
    }

    public boolean isVerifySSL() {
        return verifySSL;
    }

    public void setVerifySSL(boolean verifySSL) {
        this.verifySSL = verifySSL;
    }

    public String getComputeName() {
        return computeName;
    }

    public void setComputeName(String computeName) {
        this.computeName = computeName;
    }
}
