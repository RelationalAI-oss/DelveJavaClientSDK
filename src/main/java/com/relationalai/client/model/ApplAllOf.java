/*
 * Delve Client SDK
 * This is a Client SDK for Delve API
 *
 * The version of the OpenAPI document: 1.1.3
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
import com.relationalai.client.model.Range;
import com.relationalai.client.model.SyntaxNode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * ApplAllOf
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class ApplAllOf {
  public static final String SERIALIZED_NAME_ARGUMENTS = "arguments";
  @SerializedName(SERIALIZED_NAME_ARGUMENTS)
  private List<SyntaxNode> arguments = null;

  public static final String SERIALIZED_NAME_ERROR = "error";
  @SerializedName(SERIALIZED_NAME_ERROR)
  private Boolean error = false;

  public static final String SERIALIZED_NAME_MISSING = "missing";
  @SerializedName(SERIALIZED_NAME_MISSING)
  private Boolean missing = false;

  public static final String SERIALIZED_NAME_RANGE = "range";
  @SerializedName(SERIALIZED_NAME_RANGE)
  private Range range;

  public static final String SERIALIZED_NAME_SYMBOL = "symbol";
  @SerializedName(SERIALIZED_NAME_SYMBOL)
  private String symbol = "";


  public ApplAllOf arguments(List<SyntaxNode> arguments) {
    
    this.arguments = arguments;
    return this;
  }

  public ApplAllOf addArgumentsItem(SyntaxNode argumentsItem) {
    if (this.arguments == null) {
      this.arguments = new ArrayList<SyntaxNode>();
    }
    this.arguments.add(argumentsItem);
    return this;
  }

   /**
   * Get arguments
   * @return arguments
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public List<SyntaxNode> getArguments() {
    return arguments;
  }


  public void setArguments(List<SyntaxNode> arguments) {
    this.arguments = arguments;
  }


  public ApplAllOf error(Boolean error) {
    
    this.error = error;
    return this;
  }

   /**
   * Get error
   * @return error
  **/
  @ApiModelProperty(required = true, value = "")

  public Boolean getError() {
    return error;
  }


  public void setError(Boolean error) {
    this.error = error;
  }


  public ApplAllOf missing(Boolean missing) {
    
    this.missing = missing;
    return this;
  }

   /**
   * Get missing
   * @return missing
  **/
  @ApiModelProperty(required = true, value = "")

  public Boolean getMissing() {
    return missing;
  }


  public void setMissing(Boolean missing) {
    this.missing = missing;
  }


  public ApplAllOf range(Range range) {
    
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


  public ApplAllOf symbol(String symbol) {
    
    this.symbol = symbol;
    return this;
  }

   /**
   * Get symbol
   * @return symbol
  **/
  @ApiModelProperty(required = true, value = "")

  public String getSymbol() {
    return symbol;
  }


  public void setSymbol(String symbol) {
    this.symbol = symbol;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ApplAllOf applAllOf = (ApplAllOf) o;
    return Objects.equals(this.arguments, applAllOf.arguments) &&
        Objects.equals(this.error, applAllOf.error) &&
        Objects.equals(this.missing, applAllOf.missing) &&
        Objects.equals(this.range, applAllOf.range) &&
        Objects.equals(this.symbol, applAllOf.symbol);
  }

  @Override
  public int hashCode() {
    return Objects.hash(arguments, error, missing, range, symbol);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ApplAllOf {\n");
    sb.append("    arguments: ").append(toIndentedString(arguments)).append("\n");
    sb.append("    error: ").append(toIndentedString(error)).append("\n");
    sb.append("    missing: ").append(toIndentedString(missing)).append("\n");
    sb.append("    range: ").append(toIndentedString(range)).append("\n");
    sb.append("    symbol: ").append(toIndentedString(symbol)).append("\n");
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

