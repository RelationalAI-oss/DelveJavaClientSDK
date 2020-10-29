/*
 * RAI Cloud SDK
 * This is a Client SDK for RAI Cloud
 *
 * The version of the OpenAPI document: 1.2.0
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
 * ComputeInfoProtocol
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class ComputeInfoProtocol {
  public static final String SERIALIZED_NAME_ACCOUNT_NAME = "account_name";
  @SerializedName(SERIALIZED_NAME_ACCOUNT_NAME)
  private String accountName;

  public static final String SERIALIZED_NAME_ID = "id";
  @SerializedName(SERIALIZED_NAME_ID)
  private String id;

  public static final String SERIALIZED_NAME_CREATED_BY = "created_by";
  @SerializedName(SERIALIZED_NAME_CREATED_BY)
  private String createdBy;

  public static final String SERIALIZED_NAME_NAME = "name";
  @SerializedName(SERIALIZED_NAME_NAME)
  private String name;

  public static final String SERIALIZED_NAME_SIZE = "size";
  @SerializedName(SERIALIZED_NAME_SIZE)
  private String size;

  public static final String SERIALIZED_NAME_REGION = "region";
  @SerializedName(SERIALIZED_NAME_REGION)
  private String region;

  public static final String SERIALIZED_NAME_INFRASTRUCTURE = "infrastructure";
  @SerializedName(SERIALIZED_NAME_INFRASTRUCTURE)
  private String infrastructure;

  public static final String SERIALIZED_NAME_STATE = "state";
  @SerializedName(SERIALIZED_NAME_STATE)
  private String state;

  public static final String SERIALIZED_NAME_REQUESTED_ON = "requested_on";
  @SerializedName(SERIALIZED_NAME_REQUESTED_ON)
  private String requestedOn;

  public static final String SERIALIZED_NAME_CREATED_ON = "created_on";
  @SerializedName(SERIALIZED_NAME_CREATED_ON)
  private String createdOn;

  public static final String SERIALIZED_NAME_DELETED_ON = "deleted_on";
  @SerializedName(SERIALIZED_NAME_DELETED_ON)
  private String deletedOn;

  public static final String SERIALIZED_NAME_MESSAGE = "message";
  @SerializedName(SERIALIZED_NAME_MESSAGE)
  private String message;


  public ComputeInfoProtocol accountName(String accountName) {
    
    this.accountName = accountName;
    return this;
  }

   /**
   * Get accountName
   * @return accountName
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getAccountName() {
    return accountName;
  }


  public void setAccountName(String accountName) {
    this.accountName = accountName;
  }


  public ComputeInfoProtocol id(String id) {
    
    this.id = id;
    return this;
  }

   /**
   * Get id
   * @return id
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getId() {
    return id;
  }


  public void setId(String id) {
    this.id = id;
  }


  public ComputeInfoProtocol createdBy(String createdBy) {
    
    this.createdBy = createdBy;
    return this;
  }

   /**
   * Get createdBy
   * @return createdBy
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getCreatedBy() {
    return createdBy;
  }


  public void setCreatedBy(String createdBy) {
    this.createdBy = createdBy;
  }


  public ComputeInfoProtocol name(String name) {
    
    this.name = name;
    return this;
  }

   /**
   * Get name
   * @return name
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getName() {
    return name;
  }


  public void setName(String name) {
    this.name = name;
  }


  public ComputeInfoProtocol size(String size) {
    
    this.size = size;
    return this;
  }

   /**
   * Get size
   * @return size
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getSize() {
    return size;
  }


  public void setSize(String size) {
    this.size = size;
  }


  public ComputeInfoProtocol region(String region) {
    
    this.region = region;
    return this;
  }

   /**
   * Get region
   * @return region
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getRegion() {
    return region;
  }


  public void setRegion(String region) {
    this.region = region;
  }


  public ComputeInfoProtocol infrastructure(String infrastructure) {
    
    this.infrastructure = infrastructure;
    return this;
  }

   /**
   * Get infrastructure
   * @return infrastructure
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getInfrastructure() {
    return infrastructure;
  }


  public void setInfrastructure(String infrastructure) {
    this.infrastructure = infrastructure;
  }


  public ComputeInfoProtocol state(String state) {
    
    this.state = state;
    return this;
  }

   /**
   * Get state
   * @return state
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getState() {
    return state;
  }


  public void setState(String state) {
    this.state = state;
  }


  public ComputeInfoProtocol requestedOn(String requestedOn) {
    
    this.requestedOn = requestedOn;
    return this;
  }

   /**
   * Get requestedOn
   * @return requestedOn
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getRequestedOn() {
    return requestedOn;
  }


  public void setRequestedOn(String requestedOn) {
    this.requestedOn = requestedOn;
  }


  public ComputeInfoProtocol createdOn(String createdOn) {
    
    this.createdOn = createdOn;
    return this;
  }

   /**
   * Get createdOn
   * @return createdOn
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getCreatedOn() {
    return createdOn;
  }


  public void setCreatedOn(String createdOn) {
    this.createdOn = createdOn;
  }


  public ComputeInfoProtocol deletedOn(String deletedOn) {
    
    this.deletedOn = deletedOn;
    return this;
  }

   /**
   * Get deletedOn
   * @return deletedOn
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getDeletedOn() {
    return deletedOn;
  }


  public void setDeletedOn(String deletedOn) {
    this.deletedOn = deletedOn;
  }


  public ComputeInfoProtocol message(String message) {
    
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
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ComputeInfoProtocol computeInfoProtocol = (ComputeInfoProtocol) o;
    return Objects.equals(this.accountName, computeInfoProtocol.accountName) &&
        Objects.equals(this.id, computeInfoProtocol.id) &&
        Objects.equals(this.createdBy, computeInfoProtocol.createdBy) &&
        Objects.equals(this.name, computeInfoProtocol.name) &&
        Objects.equals(this.size, computeInfoProtocol.size) &&
        Objects.equals(this.region, computeInfoProtocol.region) &&
        Objects.equals(this.infrastructure, computeInfoProtocol.infrastructure) &&
        Objects.equals(this.state, computeInfoProtocol.state) &&
        Objects.equals(this.requestedOn, computeInfoProtocol.requestedOn) &&
        Objects.equals(this.createdOn, computeInfoProtocol.createdOn) &&
        Objects.equals(this.deletedOn, computeInfoProtocol.deletedOn) &&
        Objects.equals(this.message, computeInfoProtocol.message);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accountName, id, createdBy, name, size, region, infrastructure, state, requestedOn, createdOn, deletedOn, message);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ComputeInfoProtocol {\n");
    sb.append("    accountName: ").append(toIndentedString(accountName)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    createdBy: ").append(toIndentedString(createdBy)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    size: ").append(toIndentedString(size)).append("\n");
    sb.append("    region: ").append(toIndentedString(region)).append("\n");
    sb.append("    infrastructure: ").append(toIndentedString(infrastructure)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    requestedOn: ").append(toIndentedString(requestedOn)).append("\n");
    sb.append("    createdOn: ").append(toIndentedString(createdOn)).append("\n");
    sb.append("    deletedOn: ").append(toIndentedString(deletedOn)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
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
