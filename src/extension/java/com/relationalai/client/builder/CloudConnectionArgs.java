package com.relationalai.client.builder;

import com.relationalai.client.api.ClientConfig;
import com.relationalai.client.model.RAIInfra;
import com.relationalai.client.model.RAIRegion;
import com.relationalai.client.model.Transaction;
import com.relationalai.infra.config.InfraMetadataConfig;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class CloudConnectionArgs {
    String dbname;
    Transaction.ModeEnum defaultOpenMode;
    String scheme;
    String host;
    int port;
    InfraMetadataConfig.Infra infra;
    InfraMetadataConfig.RaiRegion region;
    ClientConfig clientConfig;
    boolean verifySSL;
    String computeName;

    @lombok.Builder
    public CloudConnectionArgs(
        String dbname,
        Transaction.ModeEnum defaultOpenMode,
        String scheme,
        String host,
        int port,
        InfraMetadataConfig.Infra infra,
        InfraMetadataConfig.RaiRegion region,
        ClientConfig clientConfig,
        boolean verifySSL,
        String computeName
    ) {
        this.dbname = dbname;
        this.defaultOpenMode = defaultOpenMode;
        this.scheme = scheme;
        this.host = host;
        this.port = port;
        this.infra = infra;
        this.region = region;
        this.clientConfig = clientConfig;
        this.verifySSL = verifySSL;
        this.computeName = computeName;
    }
}
