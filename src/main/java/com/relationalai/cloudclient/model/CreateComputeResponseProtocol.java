/*
 * RAI Cloud SDK
 * This is a Client SDK for RAI Cloud
 *
 * The version of the OpenAPI document: 1.0.8
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

/**
 * CreateComputeResponseProtocol
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class CreateComputeResponseProtocol {
  public static final String SERIALIZED_NAME_COMPUTE_DATA = "compute_data";
  @SerializedName(SERIALIZED_NAME_COMPUTE_DATA)
  private ComputeData computeData;


  public CreateComputeResponseProtocol computeData(ComputeData computeData) {
    
    this.computeData = computeData;
    return this;
  }

   /**
   * Get computeData
   * @return computeData
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public ComputeData getComputeData() {
    return computeData;
  }


  public void setComputeData(ComputeData computeData) {
    this.computeData = computeData;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateComputeResponseProtocol createComputeResponseProtocol = (CreateComputeResponseProtocol) o;
    return Objects.equals(this.computeData, createComputeResponseProtocol.computeData);
  }

  @Override
  public int hashCode() {
    return Objects.hash(computeData);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateComputeResponseProtocol {\n");
    sb.append("    computeData: ").append(toIndentedString(computeData)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

