package com.relationalai.client.builder;

import com.relationalai.client.api.ClientConfig;
import com.relationalai.client.model.RAIInfra;
import com.relationalai.client.model.RAIRegion;
import com.relationalai.infra.config.InfraMetadataConfig;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class ManagementConnectionArgs {
    String scheme;
    String host;
    int port;
    InfraMetadataConfig.Infra infra;
    InfraMetadataConfig.RaiRegion region;
    ClientConfig clientConfig;
    Boolean verifySSL;

    @lombok.Builder
    public ManagementConnectionArgs(
            String scheme,
            String host,
            int port,
            InfraMetadataConfig.Infra infra,
            InfraMetadataConfig.RaiRegion region,
            ClientConfig clientConfig,
            boolean verifySSL
    ){
        this.scheme = scheme;
        this.host = host;
        this.port = port;
        this.infra = infra;
        this.region = region;
        this.clientConfig = clientConfig;
        this.verifySSL = verifySSL;
    }
}
