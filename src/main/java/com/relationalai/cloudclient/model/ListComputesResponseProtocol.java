/*
 * RAI Cloud SDK
 * This is a Client SDK for RAI Cloud
 *
 * The version of the OpenAPI document: 1.0.0
 * Contact: support@relational.ai
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package com.relationalai.cloudclient.model;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.relationalai.cloudclient.model.ComputeData;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * ListComputesResponseProtocol
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class ListComputesResponseProtocol {
  public static final String SERIALIZED_NAME_COMPUTE_REQUESTS_LIST = "compute_requests_list";
  @SerializedName(SERIALIZED_NAME_COMPUTE_REQUESTS_LIST)
  private List<ComputeData> computeRequestsList = null;


  public ListComputesResponseProtocol computeRequestsList(List<ComputeData> computeRequestsList) {
    
    this.computeRequestsList = computeRequestsList;
    return this;
  }

  public ListComputesResponseProtocol addComputeRequestsListItem(ComputeData computeRequestsListItem) {
    if (this.computeRequestsList == null) {
      this.computeRequestsList = new ArrayList<ComputeData>();
    }
    this.computeRequestsList.add(computeRequestsListItem);
    return this;
  }

   /**
   * Get computeRequestsList
   * @return computeRequestsList
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public List<ComputeData> getComputeRequestsList() {
    return computeRequestsList;
  }


  public void setComputeRequestsList(List<ComputeData> computeRequestsList) {
    this.computeRequestsList = computeRequestsList;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ListComputesResponseProtocol listComputesResponseProtocol = (ListComputesResponseProtocol) o;
    return Objects.equals(this.computeRequestsList, listComputesResponseProtocol.computeRequestsList);
  }

  @Override
  public int hashCode() {
    return Objects.hash(computeRequestsList);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ListComputesResponseProtocol {\n");
    sb.append("    computeRequestsList: ").append(toIndentedString(computeRequestsList)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}
