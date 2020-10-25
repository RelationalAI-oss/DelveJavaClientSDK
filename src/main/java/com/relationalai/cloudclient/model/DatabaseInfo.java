/*
 * RAI Cloud SDK
 * This is a Client SDK for RAI Cloud
 *
 * The version of the OpenAPI document: 1.1.1
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
 * DatabaseInfo
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class DatabaseInfo {
  public static final String SERIALIZED_NAME_ACCOUNT_NAME = "account_name";
  @SerializedName(SERIALIZED_NAME_ACCOUNT_NAME)
  private String accountName;

  public static final String SERIALIZED_NAME_NAME = "name";
  @SerializedName(SERIALIZED_NAME_NAME)
  private String name;

  public static final String SERIALIZED_NAME_REGION = "region";
  @SerializedName(SERIALIZED_NAME_REGION)
  private String region;

  public static final String SERIALIZED_NAME_DATABASE_ID = "database_id";
  @SerializedName(SERIALIZED_NAME_DATABASE_ID)
  private String databaseId;

  public static final String SERIALIZED_NAME_DEFAULT_COMPUTE_NAME = "default_compute_name";
  @SerializedName(SERIALIZED_NAME_DEFAULT_COMPUTE_NAME)
  private String defaultComputeName;

  public static final String SERIALIZED_NAME_STATUS = "status";
  @SerializedName(SERIALIZED_NAME_STATUS)
  private String status;


  public DatabaseInfo accountName(String accountName) {
    
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


  public DatabaseInfo name(String name) {
    
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


  public DatabaseInfo region(String region) {
    
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


  public DatabaseInfo databaseId(String databaseId) {
    
    this.databaseId = databaseId;
    return this;
  }

   /**
   * Get databaseId
   * @return databaseId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getDatabaseId() {
    return databaseId;
  }


  public void setDatabaseId(String databaseId) {
    this.databaseId = databaseId;
  }


  public DatabaseInfo defaultComputeName(String defaultComputeName) {
    
    this.defaultComputeName = defaultComputeName;
    return this;
  }

   /**
   * Get defaultComputeName
   * @return defaultComputeName
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getDefaultComputeName() {
    return defaultComputeName;
  }


  public void setDefaultComputeName(String defaultComputeName) {
    this.defaultComputeName = defaultComputeName;
  }


  public DatabaseInfo status(String status) {
    
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


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DatabaseInfo databaseInfo = (DatabaseInfo) o;
    return Objects.equals(this.accountName, databaseInfo.accountName) &&
        Objects.equals(this.name, databaseInfo.name) &&
        Objects.equals(this.region, databaseInfo.region) &&
        Objects.equals(this.databaseId, databaseInfo.databaseId) &&
        Objects.equals(this.defaultComputeName, databaseInfo.defaultComputeName) &&
        Objects.equals(this.status, databaseInfo.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accountName, name, region, databaseId, defaultComputeName, status);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DatabaseInfo {\n");
    sb.append("    accountName: ").append(toIndentedString(accountName)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    region: ").append(toIndentedString(region)).append("\n");
    sb.append("    databaseId: ").append(toIndentedString(databaseId)).append("\n");
    sb.append("    defaultComputeName: ").append(toIndentedString(defaultComputeName)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
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

