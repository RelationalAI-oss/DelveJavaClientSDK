/*
 * Delve Client SDK
 * This is a Client SDK for Delve API
 *
 * The version of the OpenAPI document: 1.0.4
 * Contact: support@relational.ai
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package com.relationalai.client.api;

import com.relationalai.client.ApiCallback;
import com.relationalai.client.ApiClient;
import com.relationalai.client.ApiException;
import com.relationalai.client.ApiResponse;
import com.relationalai.client.Configuration;
import com.relationalai.client.Pair;
import com.relationalai.client.ProgressRequestBody;
import com.relationalai.client.ProgressResponseBody;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;


import com.relationalai.client.model.InfraError;
import com.relationalai.client.model.Transaction;
import com.relationalai.client.model.TransactionResult;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DefaultApi {
    private ApiClient localVarApiClient;

    public DefaultApi() {
        this(Configuration.getDefaultApiClient());
    }

    public DefaultApi(ApiClient apiClient) {
        this.localVarApiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return localVarApiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.localVarApiClient = apiClient;
    }

    /**
     * Build call for transactionPost
     * @param transaction Optional description in *Markdown* (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> A successful result is wrapped inside a TransactionResult </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> All errors are also wrapped inside a TransactionResult </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call transactionPostCall(Transaction transaction, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = transaction;

        // create path and map variables
        String localVarPath = "/transaction";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        String[] localVarAuthNames = new String[] {  };
        return localVarApiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call transactionPostValidateBeforeCall(Transaction transaction, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'transaction' is set
        if (transaction == null) {
            throw new ApiException("Missing the required parameter 'transaction' when calling transactionPost(Async)");
        }
        

        okhttp3.Call localVarCall = transactionPostCall(transaction, _callback);
        return localVarCall;

    }

    /**
     * Issues a transaction to be executed
     * 
     * @param transaction Optional description in *Markdown* (required)
     * @return TransactionResult
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> A successful result is wrapped inside a TransactionResult </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> All errors are also wrapped inside a TransactionResult </td><td>  -  </td></tr>
     </table>
     */
    public TransactionResult transactionPost(Transaction transaction) throws ApiException {
        ApiResponse<TransactionResult> localVarResp = transactionPostWithHttpInfo(transaction);
        return localVarResp.getData();
    }

    /**
     * Issues a transaction to be executed
     * 
     * @param transaction Optional description in *Markdown* (required)
     * @return ApiResponse&lt;TransactionResult&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> A successful result is wrapped inside a TransactionResult </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> All errors are also wrapped inside a TransactionResult </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<TransactionResult> transactionPostWithHttpInfo(Transaction transaction) throws ApiException {
        okhttp3.Call localVarCall = transactionPostValidateBeforeCall(transaction, null);
        Type localVarReturnType = new TypeToken<TransactionResult>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Issues a transaction to be executed (asynchronously)
     * 
     * @param transaction Optional description in *Markdown* (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> A successful result is wrapped inside a TransactionResult </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> All errors are also wrapped inside a TransactionResult </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call transactionPostAsync(Transaction transaction, final ApiCallback<TransactionResult> _callback) throws ApiException {

        okhttp3.Call localVarCall = transactionPostValidateBeforeCall(transaction, _callback);
        Type localVarReturnType = new TypeToken<TransactionResult>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
}
