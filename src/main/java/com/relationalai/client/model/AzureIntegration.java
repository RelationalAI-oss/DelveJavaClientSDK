/*
 * Delve Client SDK
 * This is a Client SDK for Delve API
 *
 * The version of the OpenAPI document: 1.1.8
 * Contact: support@relational.ai
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package com.relationalai.client.model;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.relationalai.client.model.Integration;
import com.relationalai.client.model.PairSymbolString;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * AzureIntegration
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class AzureIntegration extends Integration {
  public static final String SERIALIZED_NAME_CREDENTIALS = "credentials";
  @SerializedName(SERIALIZED_NAME_CREDENTIALS)
  private List<PairSymbolString> credentials = null;

  public static final String SERIALIZED_NAME_NAME = "name";
  @SerializedName(SERIALIZED_NAME_NAME)
  private String name;

  public static final String SERIALIZED_NAME_STORAGE_ALLOWED_LOCATIONS = "storage_allowed_locations";
  @SerializedName(SERIALIZED_NAME_STORAGE_ALLOWED_LOCATIONS)
  private List<String> storageAllowedLocations = null;

  public static final String SERIALIZED_NAME_STORAGE_BLOCKED_LOCATIONS = "storage_blocked_locations";
  @SerializedName(SERIALIZED_NAME_STORAGE_BLOCKED_LOCATIONS)
  private List<String> storageBlockedLocations = null;

  public static final String SERIALIZED_NAME_TENANT_ID = "tenant_id";
  @SerializedName(SERIALIZED_NAME_TENANT_ID)
  private String tenantId;

  public AzureIntegration() {
    this.type = this.getClass().getSimpleName();
  }

  public AzureIntegration credentials(List<PairSymbolString> credentials) {
    
    this.credentials = credentials;
    return this;
  }

  public AzureIntegration addCredentialsItem(PairSymbolString credentialsItem) {
    if (this.credentials == null) {
      this.credentials = new ArrayList<PairSymbolString>();
    }
    this.credentials.add(credentialsItem);
    return this;
  }

   /**
   * Get credentials
   * @return credentials
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public List<PairSymbolString> getCredentials() {
    return credentials;
  }


  public void setCredentials(List<PairSymbolString> credentials) {
    this.credentials = credentials;
  }


  public AzureIntegration name(String name) {
    
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


  public AzureIntegration storageAllowedLocations(List<String> storageAllowedLocations) {
    
    this.storageAllowedLocations = storageAllowedLocations;
    return this;
  }

  public AzureIntegration addStorageAllowedLocationsItem(String storageAllowedLocationsItem) {
    if (this.storageAllowedLocations == null) {
      this.storageAllowedLocations = new ArrayList<String>();
    }
    this.storageAllowedLocations.add(storageAllowedLocationsItem);
    return this;
  }

   /**
   * Get storageAllowedLocations
   * @return storageAllowedLocations
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public List<String> getStorageAllowedLocations() {
    return storageAllowedLocations;
  }


  public void setStorageAllowedLocations(List<String> storageAllowedLocations) {
    this.storageAllowedLocations = storageAllowedLocations;
  }


  public AzureIntegration storageBlockedLocations(List<String> storageBlockedLocations) {
    
    this.storageBlockedLocations = storageBlockedLocations;
    return this;
  }

  public AzureIntegration addStorageBlockedLocationsItem(String storageBlockedLocationsItem) {
    if (this.storageBlockedLocations == null) {
      this.storageBlockedLocations = new ArrayList<String>();
    }
    this.storageBlockedLocations.add(storageBlockedLocationsItem);
    return this;
  }

   /**
   * Get storageBlockedLocations
   * @return storageBlockedLocations
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public List<String> getStorageBlockedLocations() {
    return storageBlockedLocations;
  }


  public void setStorageBlockedLocations(List<String> storageBlockedLocations) {
    this.storageBlockedLocations = storageBlockedLocations;
  }


  public AzureIntegration tenantId(String tenantId) {
    
    this.tenantId = tenantId;
    return this;
  }

   /**
   * Get tenantId
   * @return tenantId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getTenantId() {
    return tenantId;
  }


  public void setTenantId(String tenantId) {
    this.tenantId = tenantId;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AzureIntegration azureIntegration = (AzureIntegration) o;
    return Objects.equals(this.credentials, azureIntegration.credentials) &&
        Objects.equals(this.name, azureIntegration.name) &&
        Objects.equals(this.storageAllowedLocations, azureIntegration.storageAllowedLocations) &&
        Objects.equals(this.storageBlockedLocations, azureIntegration.storageBlockedLocations) &&
        Objects.equals(this.tenantId, azureIntegration.tenantId) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(credentials, name, storageAllowedLocations, storageBlockedLocations, tenantId, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AzureIntegration {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    credentials: ").append(toIndentedString(credentials)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    storageAllowedLocations: ").append(toIndentedString(storageAllowedLocations)).append("\n");
    sb.append("    storageBlockedLocations: ").append(toIndentedString(storageBlockedLocations)).append("\n");
    sb.append("    tenantId: ").append(toIndentedString(tenantId)).append("\n");
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

