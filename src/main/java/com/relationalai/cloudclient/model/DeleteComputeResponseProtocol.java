/*
 * RAI Cloud SDK
 * This is a Client SDK for RAI Cloud
 *
 * The version of the OpenAPI document: 1.0.6
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
import com.relationalai.cloudclient.model.DeleteComputeStatus;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

/**
 * DeleteComputeResponseProtocol
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class DeleteComputeResponseProtocol {
  public static final String SERIALIZED_NAME_DELETE_STATUS = "delete_status";
  @SerializedName(SERIALIZED_NAME_DELETE_STATUS)
  private DeleteComputeStatus deleteStatus;


  public DeleteComputeResponseProtocol deleteStatus(DeleteComputeStatus deleteStatus) {
    
    this.deleteStatus = deleteStatus;
    return this;
  }

   /**
   * Get deleteStatus
   * @return deleteStatus
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public DeleteComputeStatus getDeleteStatus() {
    return deleteStatus;
  }


  public void setDeleteStatus(DeleteComputeStatus deleteStatus) {
    this.deleteStatus = deleteStatus;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DeleteComputeResponseProtocol deleteComputeResponseProtocol = (DeleteComputeResponseProtocol) o;
    return Objects.equals(this.deleteStatus, deleteComputeResponseProtocol.deleteStatus);
  }

  @Override
  public int hashCode() {
    return Objects.hash(deleteStatus);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DeleteComputeResponseProtocol {\n");
    sb.append("    deleteStatus: ").append(toIndentedString(deleteStatus)).append("\n");
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

