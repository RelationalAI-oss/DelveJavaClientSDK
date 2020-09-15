/*
 * RAI Cloud SDK
 * This is a Client SDK for RAI Cloud
 *
 * The version of the OpenAPI document: 1.0.0
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
 * UpdateDatabaseRequestProtocol
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class UpdateDatabaseRequestProtocol {
  public static final String SERIALIZED_NAME_DISPLAY_NAME = "display_name";
  @SerializedName(SERIALIZED_NAME_DISPLAY_NAME)
  private String displayName;

  public static final String SERIALIZED_NAME_DEFAULT_COMPUTE_NAME = "default_compute_name";
  @SerializedName(SERIALIZED_NAME_DEFAULT_COMPUTE_NAME)
  private String defaultComputeName;

  public static final String SERIALIZED_NAME_REMOVE_DEFAULT_COMPUTE = "remove_default_compute";
  @SerializedName(SERIALIZED_NAME_REMOVE_DEFAULT_COMPUTE)
  private Boolean removeDefaultCompute;

  public static final String SERIALIZED_NAME_DRYRUN = "dryrun";
  @SerializedName(SERIALIZED_NAME_DRYRUN)
  private Boolean dryrun;


  public UpdateDatabaseRequestProtocol displayName(String displayName) {
    
    this.displayName = displayName;
    return this;
  }

   /**
   * Get displayName
   * @return displayName
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getDisplayName() {
    return displayName;
  }


  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }


  public UpdateDatabaseRequestProtocol defaultComputeName(String defaultComputeName) {
    
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


  public UpdateDatabaseRequestProtocol removeDefaultCompute(Boolean removeDefaultCompute) {
    
    this.removeDefaultCompute = removeDefaultCompute;
    return this;
  }

   /**
   * Get removeDefaultCompute
   * @return removeDefaultCompute
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Boolean getRemoveDefaultCompute() {
    return removeDefaultCompute;
  }


  public void setRemoveDefaultCompute(Boolean removeDefaultCompute) {
    this.removeDefaultCompute = removeDefaultCompute;
  }


  public UpdateDatabaseRequestProtocol dryrun(Boolean dryrun) {
    
    this.dryrun = dryrun;
    return this;
  }

   /**
   * Get dryrun
   * @return dryrun
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Boolean getDryrun() {
    return dryrun;
  }


  public void setDryrun(Boolean dryrun) {
    this.dryrun = dryrun;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UpdateDatabaseRequestProtocol updateDatabaseRequestProtocol = (UpdateDatabaseRequestProtocol) o;
    return Objects.equals(this.displayName, updateDatabaseRequestProtocol.displayName) &&
        Objects.equals(this.defaultComputeName, updateDatabaseRequestProtocol.defaultComputeName) &&
        Objects.equals(this.removeDefaultCompute, updateDatabaseRequestProtocol.removeDefaultCompute) &&
        Objects.equals(this.dryrun, updateDatabaseRequestProtocol.dryrun);
  }

  @Override
  public int hashCode() {
    return Objects.hash(displayName, defaultComputeName, removeDefaultCompute, dryrun);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdateDatabaseRequestProtocol {\n");
    sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
    sb.append("    defaultComputeName: ").append(toIndentedString(defaultComputeName)).append("\n");
    sb.append("    removeDefaultCompute: ").append(toIndentedString(removeDefaultCompute)).append("\n");
    sb.append("    dryrun: ").append(toIndentedString(dryrun)).append("\n");
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
