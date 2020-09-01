/*
 * Delve Client SDK
 * This is a Client SDK for Delve API
 *
 * The version of the OpenAPI document: 1.0.0
 * Contact: support@relational.ai
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package com.relationalai.client.api;

import com.relationalai.client.ApiException;
import com.relationalai.client.model.Transaction;
import org.junit.Test;

/**
 * API tests for DefaultApi
 */
public class CloudIntegrationTests {

    public final static Transaction.ModeEnum DEFAULT_OPEN_MODE = Transaction.ModeEnum.OPEN;
    public final static String DEFAULT_SCHEME = "https";
    public final static String DEFAULT_HOST = "azure-ssh.relationalai.com";
    public final static int DEFAULT_PORT = 443;
    public final static boolean DEFAULT_VERIFY_SSL = false;
    private final static String DATABSE_NAME = "testclientdb11";
    private final static String DEFAULT_COMPUTE_NAME = DATABSE_NAME;
    private static DelveClient api = null;

    static {
        try {
            api = new DelveClient(new CloudConnection(
                    DATABSE_NAME, DEFAULT_OPEN_MODE, DEFAULT_SCHEME, DEFAULT_HOST, DEFAULT_PORT,
                    ClientConfig.loadConfig(ClientConfig.getConfigDir(ClientConfig.getDefaultConfigDir()), ClientConfig.DEFAULT_PROFILE_NAME),
                    DEFAULT_VERIFY_SSL, DEFAULT_COMPUTE_NAME
            ));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Issues a transaction to be executed
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void transactionPostTest() throws ApiException {

        IntegrationTestsCommons.transactionPostTest(api);
    }


}
