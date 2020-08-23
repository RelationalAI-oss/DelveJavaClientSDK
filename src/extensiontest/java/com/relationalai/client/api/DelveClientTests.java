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
import com.relationalai.client.model.*;
import org.junit.Test;

/**
 * API tests for DefaultApi
 */
public class DelveClientTests {

    private final String DATABSE_NAME = "testdb";
    private final DelveClient api = new DelveClient(DATABSE_NAME);

    /**
     * Issues a transaction to be executed
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void transactionPostTest() throws ApiException {

        String dbname = "testjavaclient";
        Connection conn = new Connection(dbname);
        assert api.create_database(conn, true);
        assert ! api.create_database(conn, false);


        assert  api.install_source(conn, "name", "name", "def foo = 1") != null;
        QueryActionResult query_res = api.query(conn, "name", "name", "def bar = 2", "bar");
        System.out.println(query_res);
    }


}
