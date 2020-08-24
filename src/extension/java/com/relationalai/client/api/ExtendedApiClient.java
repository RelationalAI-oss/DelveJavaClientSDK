package com.relationalai.client.api;

import com.relationalai.client.ApiClient;

public class ExtendedApiClient extends ApiClient {
    public ApiClient setUserAgent(String userAgent) {
        // addDefaultHeader("User-Agent", userAgent);
        return this;
    }
}
