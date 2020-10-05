/*
 * RAI Cloud SDK
 * This is a Client SDK for RAI Cloud
 *
 * The version of the OpenAPI document: 1.0.8
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
import com.relationalai.cloudclient.model.UserInfoProtocol;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

/**
 * CreateUserResponseProtocol
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class CreateUserResponseProtocol {
  public static final String SERIALIZED_NAME_USER = "user";
  @SerializedName(SERIALIZED_NAME_USER)
  private UserInfoProtocol user;

  public static final String SERIALIZED_NAME_PRIVATE_KEY = "private_key";
  @SerializedName(SERIALIZED_NAME_PRIVATE_KEY)
  private String privateKey;


  public CreateUserResponseProtocol user(UserInfoProtocol user) {
    
    this.user = user;
    return this;
  }

   /**
   * Get user
   * @return user
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public UserInfoProtocol getUser() {
    return user;
  }


  public void setUser(UserInfoProtocol user) {
    this.user = user;
  }


  public CreateUserResponseProtocol privateKey(String privateKey) {
    
    this.privateKey = privateKey;
    return this;
  }

   /**
   * Get privateKey
   * @return privateKey
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getPrivateKey() {
    return privateKey;
  }


  public void setPrivateKey(String privateKey) {
    this.privateKey = privateKey;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateUserResponseProtocol createUserResponseProtocol = (CreateUserResponseProtocol) o;
    return Objects.equals(this.user, createUserResponseProtocol.user) &&
        Objects.equals(this.privateKey, createUserResponseProtocol.privateKey);
  }

  @Override
  public int hashCode() {
    return Objects.hash(user, privateKey);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateUserResponseProtocol {\n");
    sb.append("    user: ").append(toIndentedString(user)).append("\n");
    sb.append("    privateKey: ").append(toIndentedString(privateKey)).append("\n");
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

