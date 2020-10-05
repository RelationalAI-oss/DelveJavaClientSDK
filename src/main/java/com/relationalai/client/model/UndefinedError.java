/*
 * Delve Client SDK
 * This is a Client SDK for Delve API
 *
 * The version of the OpenAPI document: 1.0.6
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
import com.relationalai.client.model.FrontProblem;
import com.relationalai.client.model.Range;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

/**
 * UndefinedError
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class UndefinedError extends FrontProblem {
  public static final String SERIALIZED_NAME_RANGE = "range";
  @SerializedName(SERIALIZED_NAME_RANGE)
  private Range range;

  public static final String SERIALIZED_NAME_VAR = "var";
  @SerializedName(SERIALIZED_NAME_VAR)
  private String var = "";

  public UndefinedError() {
    this.type = this.getClass().getSimpleName();
  }

  public UndefinedError range(Range range) {
    
    this.range = range;
    return this;
  }

   /**
   * Get range
   * @return range
  **/
  @ApiModelProperty(required = true, value = "")

  public Range getRange() {
    return range;
  }


  public void setRange(Range range) {
    this.range = range;
  }


  public UndefinedError var(String var) {
    
    this.var = var;
    return this;
  }

   /**
   * Get var
   * @return var
  **/
  @ApiModelProperty(required = true, value = "")

  public String getVar() {
    return var;
  }


  public void setVar(String var) {
    this.var = var;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UndefinedError undefinedError = (UndefinedError) o;
    return Objects.equals(this.range, undefinedError.range) &&
        Objects.equals(this.var, undefinedError.var) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(range, var, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UndefinedError {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    range: ").append(toIndentedString(range)).append("\n");
    sb.append("    var: ").append(toIndentedString(var)).append("\n");
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

