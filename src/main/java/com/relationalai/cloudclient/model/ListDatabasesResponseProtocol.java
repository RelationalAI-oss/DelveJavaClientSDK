/*
 * RAI Cloud SDK
 * This is a Client SDK for RAI Cloud
 *
 * The version of the OpenAPI document: 1.0.4
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
import com.relationalai.cloudclient.model.DatabaseInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * ListDatabasesResponseProtocol
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class ListDatabasesResponseProtocol {
  public static final String SERIALIZED_NAME_DATABASES = "databases";
  @SerializedName(SERIALIZED_NAME_DATABASES)
  private List<DatabaseInfo> databases = null;


  public ListDatabasesResponseProtocol databases(List<DatabaseInfo> databases) {
    
    this.databases = databases;
    return this;
  }

  public ListDatabasesResponseProtocol addDatabasesItem(DatabaseInfo databasesItem) {
    if (this.databases == null) {
      this.databases = new ArrayList<DatabaseInfo>();
    }
    this.databases.add(databasesItem);
    return this;
  }

   /**
   * Get databases
   * @return databases
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public List<DatabaseInfo> getDatabases() {
    return databases;
  }


  public void setDatabases(List<DatabaseInfo> databases) {
    this.databases = databases;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ListDatabasesResponseProtocol listDatabasesResponseProtocol = (ListDatabasesResponseProtocol) o;
    return Objects.equals(this.databases, listDatabasesResponseProtocol.databases);
  }

  @Override
  public int hashCode() {
    return Objects.hash(databases);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ListDatabasesResponseProtocol {\n");
    sb.append("    databases: ").append(toIndentedString(databases)).append("\n");
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

