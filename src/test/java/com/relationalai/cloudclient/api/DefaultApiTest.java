/*
 * RAI Cloud SDK
 * This is a Client SDK for RAI Cloud
 *
 * The version of the OpenAPI document: 1.0.13
 * Contact: support@relational.ai
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package com.relationalai.cloudclient.api;

import com.relationalai.cloudclient.ApiException;
import com.relationalai.cloudclient.model.CreateComputeRequestProtocol;
import com.relationalai.cloudclient.model.CreateComputeResponseProtocol;
import com.relationalai.cloudclient.model.CreateUserRequestProtocol;
import com.relationalai.cloudclient.model.CreateUserResponseProtocol;
import com.relationalai.cloudclient.model.DeleteComputeRequestProtocol;
import com.relationalai.cloudclient.model.DeleteComputeResponseProtocol;
import com.relationalai.cloudclient.model.ListComputesResponseProtocol;
import com.relationalai.cloudclient.model.ListDatabasesResponseProtocol;
import com.relationalai.cloudclient.model.ListUsersResponseProtocol;
import com.relationalai.cloudclient.model.UpdateDatabaseRequestProtocol;
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
     * Delete compute
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void computeDeleteTest() throws ApiException {
        DeleteComputeRequestProtocol deleteComputeRequestProtocol = null;
        DeleteComputeResponseProtocol response = api.computeDelete(deleteComputeRequestProtocol);

        // TODO: test validations
    }
    
    /**
     * List computes
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void computeGetTest() throws ApiException {
        List<String> id = null;
        List<String> name = null;
        List<String> size = null;
        List<String> state = null;
        ListComputesResponseProtocol response = api.computeGet(id, name, size, state);

        // TODO: test validations
    }
    
    /**
     * Create compute
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void computePutTest() throws ApiException {
        CreateComputeRequestProtocol createComputeRequestProtocol = null;
        CreateComputeResponseProtocol response = api.computePut(createComputeRequestProtocol);

        // TODO: test validations
    }
    
    /**
     * List databases
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void databaseGetTest() throws ApiException {
        ListDatabasesResponseProtocol response = api.databaseGet();

        // TODO: test validations
    }
    
    /**
     * Update database
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void databasePostTest() throws ApiException {
        UpdateDatabaseRequestProtocol updateDatabaseRequestProtocol = null;
        api.databasePost(updateDatabaseRequestProtocol);

        // TODO: test validations
    }
    
    /**
     * List users
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void userGetTest() throws ApiException {
        ListUsersResponseProtocol response = api.userGet();

        // TODO: test validations
    }
    
    /**
     * Create user
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void userPutTest() throws ApiException {
        CreateUserRequestProtocol createUserRequestProtocol = null;
        CreateUserResponseProtocol response = api.userPut(createUserRequestProtocol);

        // TODO: test validations
    }
    
}
