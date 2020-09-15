package com.relationalai.client.api;

import com.relationalai.client.model.Transaction;

public class LocalConnection extends Connection {
    private String dbName;
    private Transaction.ModeEnum defaultOpenMode;

    public LocalConnection(String dname) {
        super(DEFAULT_SCHEME, DEFAULT_HOST, DEFAULT_PORT);
    }

    public LocalConnection(Connection conn) {
        this(conn.getDbName(), conn.getDefaultOpenMode(), conn.getScheme(), conn.getHost(), conn.getPort());
    }

    public LocalConnection(
            String dbname,
            Transaction.ModeEnum defaultOpenMode,
            String scheme,
            String host,
            int port) {
        super(scheme, host, port);
        this.defaultOpenMode = defaultOpenMode;
        this.dbName = dbname;

        if(this.getClass() == LocalConnection.class) {
            new DelveClient(this); //to register the connection with a client
        } else {
            // If it's a subtype of `LocalConnection`, then its association to a `DelveClient`
            // is done separately in the leaf class.
        }
    }

    @Override
    public String getDbName() {
        return dbName;
    }

    @Override
    public Transaction.ModeEnum getDefaultOpenMode() {
        return defaultOpenMode;
    }
}
