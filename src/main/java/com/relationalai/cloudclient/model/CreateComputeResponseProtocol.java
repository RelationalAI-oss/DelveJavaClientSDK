/*
 * RAI Cloud SDK
 * This is a Client SDK for RAI Cloud
 *
 * The version of the OpenAPI document: 1.3.1
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
import com.relationalai.cloudclient.model.ComputeInfoProtocol;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

/**
 * CreateComputeResponseProtocol
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class CreateComputeResponseProtocol {
  public static final String SERIALIZED_NAME_COMPUTE = "compute";
  @SerializedName(SERIALIZED_NAME_COMPUTE)
  private ComputeInfoProtocol compute;


  public CreateComputeResponseProtocol compute(ComputeInfoProtocol compute) {
    
    this.compute = compute;
    return this;
  }

   /**
   * Get compute
   * @return compute
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public ComputeInfoProtocol getCompute() {
    return compute;
  }


  public void setCompute(ComputeInfoProtocol compute) {
    this.compute = compute;
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
    return Objects.equals(this.compute, createComputeResponseProtocol.compute);
  }

  @Override
  public int hashCode() {
    return Objects.hash(compute);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateComputeResponseProtocol {\n");
    sb.append("    compute: ").append(toIndentedString(compute)).append("\n");
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

