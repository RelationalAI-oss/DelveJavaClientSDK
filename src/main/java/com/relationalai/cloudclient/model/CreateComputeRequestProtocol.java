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
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

/**
 * CreateComputeRequestProtocol
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class CreateComputeRequestProtocol {
  public static final String SERIALIZED_NAME_REGION = "region";
  @SerializedName(SERIALIZED_NAME_REGION)
  private String region;

  public static final String SERIALIZED_NAME_DISPLAY_NAME = "display_name";
  @SerializedName(SERIALIZED_NAME_DISPLAY_NAME)
  private String displayName;

  public static final String SERIALIZED_NAME_SIZE = "size";
  @SerializedName(SERIALIZED_NAME_SIZE)
  private String size;

  public static final String SERIALIZED_NAME_DRYRUN = "dryrun";
  @SerializedName(SERIALIZED_NAME_DRYRUN)
  private Boolean dryrun;


  public CreateComputeRequestProtocol region(String region) {
    
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


  public CreateComputeRequestProtocol displayName(String displayName) {
    
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


  public CreateComputeRequestProtocol size(String size) {
    
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


  public CreateComputeRequestProtocol dryrun(Boolean dryrun) {
    
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
    CreateComputeRequestProtocol createComputeRequestProtocol = (CreateComputeRequestProtocol) o;
    return Objects.equals(this.region, createComputeRequestProtocol.region) &&
        Objects.equals(this.displayName, createComputeRequestProtocol.displayName) &&
        Objects.equals(this.size, createComputeRequestProtocol.size) &&
        Objects.equals(this.dryrun, createComputeRequestProtocol.dryrun);
  }

  @Override
  public int hashCode() {
    return Objects.hash(region, displayName, size, dryrun);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateComputeRequestProtocol {\n");
    sb.append("    region: ").append(toIndentedString(region)).append("\n");
    sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
    sb.append("    size: ").append(toIndentedString(size)).append("\n");
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

