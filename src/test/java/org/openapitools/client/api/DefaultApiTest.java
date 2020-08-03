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


package org.openapitools.client.api;

import ai.relational.client.ApiException;
import org.openapitools.client.model.Transaction;
import org.openapitools.client.model.TransactionResult;
import org.junit.Test;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for DefaultApi
 */
@Ignore
public class DefaultApiTest {

    private final DefaultApi api = new DefaultApi();

    
    /**
     * Issues a transaction to be executed
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void transactionPostTest() throws ApiException {
        Transaction transaction = null;
        TransactionResult response = api.transactionPost(transaction);

        // TODO: test validations
    }
    
}
