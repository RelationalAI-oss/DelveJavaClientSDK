/*
 * Delve Client SDK
 * This is a Client SDK for Delve API
 *
 * The version of the OpenAPI document: 1.0.11
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
import com.relationalai.client.model.Action;
import com.relationalai.client.model.Source;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

/**
 * ParseAction
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class ParseAction extends Action {
  public static final String SERIALIZED_NAME_NONTERM = "nonterm";
  @SerializedName(SERIALIZED_NAME_NONTERM)
  private String nonterm = "";

  public static final String SERIALIZED_NAME_SOURCE = "source";
  @SerializedName(SERIALIZED_NAME_SOURCE)
  private Source source;

  public ParseAction() {
    this.type = this.getClass().getSimpleName();
  }

  public ParseAction nonterm(String nonterm) {
    
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


  public ParseAction source(Source source) {
    
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
    ParseAction parseAction = (ParseAction) o;
    return Objects.equals(this.nonterm, parseAction.nonterm) &&
        Objects.equals(this.source, parseAction.source) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nonterm, source, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ParseAction {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
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

