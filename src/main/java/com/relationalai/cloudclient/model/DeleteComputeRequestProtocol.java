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
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

/**
 * DeleteComputeRequestProtocol
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class DeleteComputeRequestProtocol {
  public static final String SERIALIZED_NAME_NAME = "name";
  @SerializedName(SERIALIZED_NAME_NAME)
  private String name;

  public static final String SERIALIZED_NAME_DRYRUN = "dryrun";
  @SerializedName(SERIALIZED_NAME_DRYRUN)
  private Boolean dryrun;


  public DeleteComputeRequestProtocol name(String name) {
    
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


  public DeleteComputeRequestProtocol dryrun(Boolean dryrun) {
    
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
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DeleteComputeRequestProtocol deleteComputeRequestProtocol = (DeleteComputeRequestProtocol) o;
    return Objects.equals(this.name, deleteComputeRequestProtocol.name) &&
        Objects.equals(this.dryrun, deleteComputeRequestProtocol.dryrun);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, dryrun);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DeleteComputeRequestProtocol {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    dryrun: ").append(toIndentedString(dryrun)).append("\n");
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

