package com.relationalai.client.api;

import com.relationalai.client.model.*;

public abstract class Connection {
    public final static String DEFAULT_SCHEME = "http";
    public final static String DEFAULT_HOST = "127.0.0.1";
    public final static int DEFAULT_PORT = 8010;
    public final static Transaction.ModeEnum DEFAULT_OPEN_MODE = Transaction.ModeEnum.OPEN;
    public final static boolean DEFAULT_VERIFY_SSL = true;
    public final static RAIInfra DEFAULT_INFRA = RAIInfra.AZURE;
    public final static RAIRegion DEFAULT_REGION = RAIRegion.US_EAST;
    public final static int DEFAULT_DEBUG_LEVEL = 0;

    private String scheme;
    private String host;
    private int port;

    public Connection(Connection conn) {
        this.scheme = conn.scheme;
        this.host = conn.host;
        this.port = conn.port;
    }

    public Connection() {
        this(DEFAULT_SCHEME, DEFAULT_HOST, DEFAULT_PORT);
    }

    public Connection(
            String scheme,
            String host,
            int port) {
        this.scheme = scheme;
        this.host = host;
        this.port = port;
    }

    public String getDbName() {
        throw new UnsupportedOperationException();
    }

    public Transaction.ModeEnum getDefaultOpenMode() {
        throw new UnsupportedOperationException();
    }

    public String getScheme() {
        return scheme;
    }

    public String getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }

    public RAIInfra getInfra() {
        throw new UnsupportedOperationException();
    }

    public RAIRegion getRegion() {
        throw new UnsupportedOperationException();
    }

    public ClientConfig getClientConfig() {
        throw new UnsupportedOperationException();
    }

    public RAICredentials getCreds() {
        return new RAICredentials(getClientConfig());
    }

    public boolean isVerifySSL() {
        return DEFAULT_VERIFY_SSL;
    }

    public String getComputeName() {
        throw new UnsupportedOperationException();
    }

    public String getBaseUrl() {
        return this.getScheme() + "://" + this.getHost() + ":" + this.getPort();
    }

    public int getDebugLevel() {
        return DEFAULT_DEBUG_LEVEL;
    }
}
