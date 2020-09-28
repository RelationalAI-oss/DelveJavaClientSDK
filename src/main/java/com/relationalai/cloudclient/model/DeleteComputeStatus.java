/*
 * RAI Cloud SDK
 * This is a Client SDK for RAI Cloud
 *
 * The version of the OpenAPI document: 1.0.3
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
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

/**
 * DeleteComputeStatus
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class DeleteComputeStatus {
  public static final String SERIALIZED_NAME_COMPUTE_NAME = "compute_name";
  @SerializedName(SERIALIZED_NAME_COMPUTE_NAME)
  private String computeName;

  public static final String SERIALIZED_NAME_STATUS = "status";
  @SerializedName(SERIALIZED_NAME_STATUS)
  private String status;

  public static final String SERIALIZED_NAME_MESSAGE = "message";
  @SerializedName(SERIALIZED_NAME_MESSAGE)
  private String message;


  public DeleteComputeStatus computeName(String computeName) {
    
    this.computeName = computeName;
    return this;
  }

   /**
   * Get computeName
   * @return computeName
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getComputeName() {
    return computeName;
  }


  public void setComputeName(String computeName) {
    this.computeName = computeName;
  }


  public DeleteComputeStatus status(String status) {
    
    this.status = status;
    return this;
  }

   /**
   * Get status
   * @return status
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getStatus() {
    return status;
  }


  public void setStatus(String status) {
    this.status = status;
  }


  public DeleteComputeStatus message(String message) {
    
    this.message = message;
    return this;
  }

   /**
   * Get message
   * @return message
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getMessage() {
    return message;
  }


  public void setMessage(String message) {
    this.message = message;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DeleteComputeStatus deleteComputeStatus = (DeleteComputeStatus) o;
    return Objects.equals(this.computeName, deleteComputeStatus.computeName) &&
        Objects.equals(this.status, deleteComputeStatus.status) &&
        Objects.equals(this.message, deleteComputeStatus.message);
  }

  @Override
  public int hashCode() {
    return Objects.hash(computeName, status, message);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DeleteComputeStatus {\n");
    sb.append("    computeName: ").append(toIndentedString(computeName)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
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

