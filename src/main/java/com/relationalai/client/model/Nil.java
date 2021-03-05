/*
 * Delve Client SDK
 * This is a Client SDK for Delve API
 *
 * The version of the OpenAPI document: 1.2.0
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
import com.relationalai.client.model.CollectProblemsActionAllOf;
import com.relationalai.client.model.LinkedList;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

/**
 * Nil
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class Nil extends LinkedList {
  public static final String SERIALIZED_NAME_DUMMY = "dummy";
  @SerializedName(SERIALIZED_NAME_DUMMY)
  private String dummy;

  public Nil() {
    this.type = this.getClass().getSimpleName();
  }

  public Nil dummy(String dummy) {
    
    this.dummy = dummy;
    return this;
  }

   /**
   * Get dummy
   * @return dummy
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getDummy() {
    return dummy;
  }


  public void setDummy(String dummy) {
    this.dummy = dummy;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Nil nil = (Nil) o;
    return Objects.equals(this.dummy, nil.dummy) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(dummy, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Nil {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    dummy: ").append(toIndentedString(dummy)).append("\n");
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

