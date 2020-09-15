package com.relationalai.client.api;

import com.relationalai.client.model.*;
import com.relationalai.infra.UnrecognizedRegionException;

import java.io.IOException;
import java.security.GeneralSecurityException;

public class CloudConnection extends LocalConnection {
    private ManagementConnection managementConn;
    private String computeName;

    public CloudConnection(Connection conn) throws UnrecognizedRegionException, GeneralSecurityException, IOException {
        this(conn, Connection.DEFAULT_INFRA, Connection.DEFAULT_REGION, null, Connection.DEFAULT_VERIFY_SSL, null);
    }
    public CloudConnection(
            Connection conn,
            RAIInfra infra,
            RAIRegion region,
            ClientConfig clientConfig,
            boolean verifySSL,
            String computeName
    ) throws UnrecognizedRegionException, GeneralSecurityException, IOException {
        this(conn.getDbName(), conn.getDefaultOpenMode(), conn.getScheme(), conn.getHost(), conn.getPort(), infra, region, clientConfig, verifySSL, computeName);
    }

    public CloudConnection(String dbname) throws UnrecognizedRegionException, GeneralSecurityException, IOException {
        this(dbname, Connection.DEFAULT_OPEN_MODE, Connection.DEFAULT_SCHEME, Connection.DEFAULT_HOST,
             Connection.DEFAULT_PORT, Connection.DEFAULT_INFRA, Connection.DEFAULT_REGION, null,
             Connection.DEFAULT_VERIFY_SSL, null);
    }

    public CloudConnection(
            String dbname,
            Transaction.ModeEnum defaultOpenMode,
            String scheme,
            String host,
            int port,
            RAIInfra infra,
            RAIRegion region,
            ClientConfig clientConfig,
            boolean verifySSL,
            String computeName
    ) throws UnrecognizedRegionException, GeneralSecurityException, IOException {
        super(dbname, defaultOpenMode, scheme, host, port);
        this.managementConn = new ManagementConnection(scheme, host, port, infra, region, clientConfig, verifySSL);
        this.computeName = computeName;

        new DelveClient(this); //to register the connection with a client
    }

    @Override
    public ClientConfig getClientConfig() {
        return managementConn.getClientConfig();
    }

    @Override
    public boolean isVerifySSL() {
        return managementConn.isVerifySSL();
    }

    @Override
    public String getComputeName() {
        return computeName;
    }
}
