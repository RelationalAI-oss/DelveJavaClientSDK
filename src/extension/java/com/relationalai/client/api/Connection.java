package com.relationalai.client.api;

import com.relationalai.client.model.Transaction;

public class Connection {
    public final static Transaction.ModeEnum DEFAULT_OPEN_MODE = Transaction.ModeEnum.OPEN;
    public final static String DEFAULT_SCHEME = "http";
    public final static String DEFAULT_HOST = "127.0.0.1";
    public final static int DEFAULT_PORT = 8010;
    public final static boolean DEFAULT_VERIFY_SSL = true;

    private String dbname;
    private Transaction.ModeEnum defaultOpenMode;
    private String scheme;
    private String host;
    private int port;

    public Connection(Connection conn) {
        this.dbname = conn.dbname;
        this.defaultOpenMode = conn.defaultOpenMode;
        this.scheme = conn.scheme;
        this.host = conn.host;
        this.port = conn.port;
    }

    public Connection(String dbname) {
        this(dbname, DEFAULT_OPEN_MODE, DEFAULT_SCHEME, DEFAULT_HOST, DEFAULT_PORT);
    }

    public Connection(
            String dbname,
            Transaction.ModeEnum defaultOpenMode,
            String scheme,
            String host,
            int port) {
        this.dbname = dbname;
        this.defaultOpenMode = defaultOpenMode;
        this.scheme = scheme;
        this.host = host;
        this.port = port;
    }

    public String getBaseUrl() {
        return this.scheme + "://" + this.host + ":" + this.port;
    }

    public String getDbname() {
        return dbname;
    }

    public Transaction.ModeEnum getDefaultOpenMode() {
        return defaultOpenMode;
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

    public ClientConfig getClientConfig() {
        return null;
    }

    public boolean isVerifySSL() {
        return DEFAULT_VERIFY_SSL;
    }

    public String getComputeName() {
        return null;
    }
}
