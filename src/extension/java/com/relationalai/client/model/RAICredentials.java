package com.relationalai.client.model;

import com.google.crypto.tink.KeysetHandle;
import com.relationalai.client.api.ClientConfig;

/**
 * RAICredentials
 *
 * Keeps user's credentials: access key and private key.
 *
 * # Fields
 * - `accessKey`: Access key
 * - `privateKey`: Private key // pragma: allowlist secret
 */
public class RAICredentials
{
    private String accessKey;
    private KeysetHandle privateKey; // pragma: allowlist secret

    public String getAccessKey() { return accessKey; }
    public KeysetHandle getPrivateKey() { return privateKey; } // pragma: allowlist secret

    public RAICredentials(String accessKey, KeysetHandle privateKey) {
        this.accessKey = accessKey;
        this.privateKey = privateKey; // pragma: allowlist secret
    }

    public RAICredentials(ClientConfig cfg) {
        this(cfg.getAccessKey(), cfg.getPrivateKeysetHandle());
    }
}
