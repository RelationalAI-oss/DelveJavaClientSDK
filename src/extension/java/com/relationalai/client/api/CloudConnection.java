package com.relationalai.client.api;

import com.relationalai.client.builder.CloudConnectionArgs;
import com.relationalai.client.builder.ManagementConnectionArgs;
import com.relationalai.client.model.*;
import com.relationalai.infra.UnrecognizedRegionException;
import com.relationalai.infra.config.InfraMetadataConfig;

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
        InfraMetadataConfig.Infra infra,
        InfraMetadataConfig.RaiRegion region,
        ClientConfig clientConfig,
        boolean verifySSL,
        String computeName
    ) throws UnrecognizedRegionException, GeneralSecurityException, IOException {
        this(new CloudConnectionArgs(
            conn.getDbName(),
            conn.getDefaultOpenMode(),
            conn.getScheme(),
            conn.getHost(),
            conn.getPort(),
            infra,
            region,
            clientConfig,
            verifySSL,
            computeName
            )
        );
    }

    public CloudConnection(
            ManagementConnection mngtConn,
            String dbName,
            String computeName
    ) throws UnrecognizedRegionException, GeneralSecurityException, IOException {
        this(new CloudConnectionArgs(
            dbName,
            mngtConn.getDefaultOpenMode(),
            mngtConn.getScheme(),
            mngtConn.getHost(),
            mngtConn.getPort(),
            mngtConn.getInfra(),
            mngtConn.getRegion(),
            mngtConn.getClientConfig(),
            mngtConn.isVerifySSL(),
            computeName
        ));
    }

    public CloudConnection(String dbname) throws UnrecognizedRegionException, GeneralSecurityException, IOException {
        this(new CloudConnectionArgs(dbname, Connection.DEFAULT_OPEN_MODE, Connection.DEFAULT_SCHEME, Connection.DEFAULT_HOST,
               Connection.DEFAULT_PORT, Connection.DEFAULT_INFRA, Connection.DEFAULT_REGION, null,
               Connection.DEFAULT_VERIFY_SSL, null));
    }

    public CloudConnection(CloudConnectionArgs args) throws UnrecognizedRegionException, GeneralSecurityException, IOException {
        super(args.getDbname(), args.getDefaultOpenMode(), args.getScheme(), args.getHost(), args.getPort());
        this.managementConn = new ManagementConnection(
            new ManagementConnectionArgs(
                args.getScheme(),
                args.getHost(),
                args.getPort(),
                args.getInfra(),
                args.getRegion(),
                args.getClientConfig(),
                args.isVerifySSL()
            )
        );
        this.computeName = args.getComputeName();
        this.setClient(new DelveClient(this)); //to register the connection with a client
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

    public ManagementConnection getManagementConn() {
        return managementConn;
    }
}
