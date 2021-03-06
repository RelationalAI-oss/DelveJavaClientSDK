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
import com.relationalai.client.model.Source;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

/**
 * ParseActionAllOf
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class ParseActionAllOf {
  public static final String SERIALIZED_NAME_NONTERM = "nonterm";
  @SerializedName(SERIALIZED_NAME_NONTERM)
  private String nonterm = "";

  public static final String SERIALIZED_NAME_SOURCE = "source";
  @SerializedName(SERIALIZED_NAME_SOURCE)
  private Source source;


  public ParseActionAllOf nonterm(String nonterm) {
    
    this.nonterm = nonterm;
    return this;
  }

   /**
   * Get nonterm
   * @return nonterm
  **/
  @ApiModelProperty(required = true, value = "")

  public String getNonterm() {
    return nonterm;
  }


  public void setNonterm(String nonterm) {
    this.nonterm = nonterm;
  }


  public ParseActionAllOf source(Source source) {
    
    this.source = source;
    return this;
  }

   /**
   * Get source
   * @return source
  **/
  @ApiModelProperty(required = true, value = "")

  public Source getSource() {
    return source;
  }


  public void setSource(Source source) {
    this.source = source;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ParseActionAllOf parseActionAllOf = (ParseActionAllOf) o;
    return Objects.equals(this.nonterm, parseActionAllOf.nonterm) &&
        Objects.equals(this.source, parseActionAllOf.source);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nonterm, source);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ParseActionAllOf {\n");
    sb.append("    nonterm: ").append(toIndentedString(nonterm)).append("\n");
    sb.append("    source: ").append(toIndentedString(source)).append("\n");
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

