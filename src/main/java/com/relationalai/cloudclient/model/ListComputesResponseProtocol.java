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
import java.util.ArrayList;
import java.util.List;

/**
 * ListComputesResponseProtocol
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class ListComputesResponseProtocol {
  public static final String SERIALIZED_NAME_COMPUTES = "computes";
  @SerializedName(SERIALIZED_NAME_COMPUTES)
  private List<ComputeInfoProtocol> computes = null;


  public ListComputesResponseProtocol computes(List<ComputeInfoProtocol> computes) {
    
    this.computes = computes;
    return this;
  }

  public ListComputesResponseProtocol addComputesItem(ComputeInfoProtocol computesItem) {
    if (this.computes == null) {
      this.computes = new ArrayList<ComputeInfoProtocol>();
    }
    this.computes.add(computesItem);
    return this;
  }

   /**
   * Get computes
   * @return computes
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public List<ComputeInfoProtocol> getComputes() {
    return computes;
  }


  public void setComputes(List<ComputeInfoProtocol> computes) {
    this.computes = computes;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ListComputesResponseProtocol listComputesResponseProtocol = (ListComputesResponseProtocol) o;
    return Objects.equals(this.computes, listComputesResponseProtocol.computes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(computes);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ListComputesResponseProtocol {\n");
    sb.append("    computes: ").append(toIndentedString(computes)).append("\n");
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

