package com.relationalai.client.api;

import com.relationalai.client.ApiClient;

public class ExtendedApiClient extends ApiClient {
    public ApiClient setUserAgent(String userAgent) {
        // The line below was present in the `ApiClient` and is removed in this override
        // addDefaultHeader("User-Agent", userAgent);
        return this;
    }
}
