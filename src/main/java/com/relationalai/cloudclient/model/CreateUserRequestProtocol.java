/*
 * RAI Cloud SDK
 * This is a Client SDK for RAI Cloud
 *
 * The version of the OpenAPI document: 1.3.0
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
 * CreateUserRequestProtocol
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class CreateUserRequestProtocol {
  public static final String SERIALIZED_NAME_USERNAME = "username";
  @SerializedName(SERIALIZED_NAME_USERNAME)
  private String username;

  public static final String SERIALIZED_NAME_DRYRUN = "dryrun";
  @SerializedName(SERIALIZED_NAME_DRYRUN)
  private Boolean dryrun;


  public CreateUserRequestProtocol username(String username) {
    
    this.username = username;
    return this;
  }

   /**
   * Get username
   * @return username
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getUsername() {
    return username;
  }


  public void setUsername(String username) {
    this.username = username;
  }


  public CreateUserRequestProtocol dryrun(Boolean dryrun) {
    
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
    CreateUserRequestProtocol createUserRequestProtocol = (CreateUserRequestProtocol) o;
    return Objects.equals(this.username, createUserRequestProtocol.username) &&
        Objects.equals(this.dryrun, createUserRequestProtocol.dryrun);
  }

  @Override
  public int hashCode() {
    return Objects.hash(username, dryrun);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateUserRequestProtocol {\n");
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
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

