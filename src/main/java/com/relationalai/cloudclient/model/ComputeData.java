/*
 * RAI Cloud SDK
 * This is a Client SDK for RAI Cloud
 *
 * The version of the OpenAPI document: 1.0.5
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
 * ComputeData
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class ComputeData {
  public static final String SERIALIZED_NAME_ID = "id";
  @SerializedName(SERIALIZED_NAME_ID)
  private String id;

  public static final String SERIALIZED_NAME_GET_ETAG = "get_etag";
  @SerializedName(SERIALIZED_NAME_GET_ETAG)
  private String getEtag;

  public static final String SERIALIZED_NAME_ACCOUNT_NAME = "accountName";
  @SerializedName(SERIALIZED_NAME_ACCOUNT_NAME)
  private String accountName;

  public static final String SERIALIZED_NAME_COMPUTE_ID = "computeId";
  @SerializedName(SERIALIZED_NAME_COMPUTE_ID)
  private String computeId;

  public static final String SERIALIZED_NAME_CREATED_BY = "createdBy";
  @SerializedName(SERIALIZED_NAME_CREATED_BY)
  private String createdBy;

  public static final String SERIALIZED_NAME_COMPUTE_NAME = "computeName";
  @SerializedName(SERIALIZED_NAME_COMPUTE_NAME)
  private String computeName;

  public static final String SERIALIZED_NAME_COMPUTE_SIZE = "computeSize";
  @SerializedName(SERIALIZED_NAME_COMPUTE_SIZE)
  private String computeSize;

  public static final String SERIALIZED_NAME_COMPUTE_REGION = "computeRegion";
  @SerializedName(SERIALIZED_NAME_COMPUTE_REGION)
  private String computeRegion;

  public static final String SERIALIZED_NAME_INFRASTRUCTURE = "infrastructure";
  @SerializedName(SERIALIZED_NAME_INFRASTRUCTURE)
  private String infrastructure;

  public static final String SERIALIZED_NAME_COMPUTE_STATE = "computeState";
  @SerializedName(SERIALIZED_NAME_COMPUTE_STATE)
  private String computeState;

  public static final String SERIALIZED_NAME_REQUESTED_ON = "requestedOn";
  @SerializedName(SERIALIZED_NAME_REQUESTED_ON)
  private String requestedOn;

  public static final String SERIALIZED_NAME_CREATED_ON = "createdOn";
  @SerializedName(SERIALIZED_NAME_CREATED_ON)
  private String createdOn;

  public static final String SERIALIZED_NAME_DELETED_ON = "deletedOn";
  @SerializedName(SERIALIZED_NAME_DELETED_ON)
  private String deletedOn;

  public static final String SERIALIZED_NAME_MESSAGE = "message";
  @SerializedName(SERIALIZED_NAME_MESSAGE)
  private String message;


  public ComputeData id(String id) {
    
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


  public ComputeData getEtag(String getEtag) {
    
    this.getEtag = getEtag;
    return this;
  }

   /**
   * Get getEtag
   * @return getEtag
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getGetEtag() {
    return getEtag;
  }


  public void setGetEtag(String getEtag) {
    this.getEtag = getEtag;
  }


  public ComputeData accountName(String accountName) {
    
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


  public ComputeData computeId(String computeId) {
    
    this.computeId = computeId;
    return this;
  }

   /**
   * Get computeId
   * @return computeId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getComputeId() {
    return computeId;
  }


  public void setComputeId(String computeId) {
    this.computeId = computeId;
  }


  public ComputeData createdBy(String createdBy) {
    
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


  public ComputeData computeName(String computeName) {
    
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


  public ComputeData computeSize(String computeSize) {
    
    this.computeSize = computeSize;
    return this;
  }

   /**
   * Get computeSize
   * @return computeSize
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getComputeSize() {
    return computeSize;
  }


  public void setComputeSize(String computeSize) {
    this.computeSize = computeSize;
  }


  public ComputeData computeRegion(String computeRegion) {
    
    this.computeRegion = computeRegion;
    return this;
  }

   /**
   * Get computeRegion
   * @return computeRegion
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getComputeRegion() {
    return computeRegion;
  }


  public void setComputeRegion(String computeRegion) {
    this.computeRegion = computeRegion;
  }


  public ComputeData infrastructure(String infrastructure) {
    
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


  public ComputeData computeState(String computeState) {
    
    this.computeState = computeState;
    return this;
  }

   /**
   * Get computeState
   * @return computeState
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getComputeState() {
    return computeState;
  }


  public void setComputeState(String computeState) {
    this.computeState = computeState;
  }


  public ComputeData requestedOn(String requestedOn) {
    
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


  public ComputeData createdOn(String createdOn) {
    
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


  public ComputeData deletedOn(String deletedOn) {
    
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


  public ComputeData message(String message) {
    
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
    ComputeData computeData = (ComputeData) o;
    return Objects.equals(this.id, computeData.id) &&
        Objects.equals(this.getEtag, computeData.getEtag) &&
        Objects.equals(this.accountName, computeData.accountName) &&
        Objects.equals(this.computeId, computeData.computeId) &&
        Objects.equals(this.createdBy, computeData.createdBy) &&
        Objects.equals(this.computeName, computeData.computeName) &&
        Objects.equals(this.computeSize, computeData.computeSize) &&
        Objects.equals(this.computeRegion, computeData.computeRegion) &&
        Objects.equals(this.infrastructure, computeData.infrastructure) &&
        Objects.equals(this.computeState, computeData.computeState) &&
        Objects.equals(this.requestedOn, computeData.requestedOn) &&
        Objects.equals(this.createdOn, computeData.createdOn) &&
        Objects.equals(this.deletedOn, computeData.deletedOn) &&
        Objects.equals(this.message, computeData.message);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, getEtag, accountName, computeId, createdBy, computeName, computeSize, computeRegion, infrastructure, computeState, requestedOn, createdOn, deletedOn, message);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ComputeData {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    getEtag: ").append(toIndentedString(getEtag)).append("\n");
    sb.append("    accountName: ").append(toIndentedString(accountName)).append("\n");
    sb.append("    computeId: ").append(toIndentedString(computeId)).append("\n");
    sb.append("    createdBy: ").append(toIndentedString(createdBy)).append("\n");
    sb.append("    computeName: ").append(toIndentedString(computeName)).append("\n");
    sb.append("    computeSize: ").append(toIndentedString(computeSize)).append("\n");
    sb.append("    computeRegion: ").append(toIndentedString(computeRegion)).append("\n");
    sb.append("    infrastructure: ").append(toIndentedString(infrastructure)).append("\n");
    sb.append("    computeState: ").append(toIndentedString(computeState)).append("\n");
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

