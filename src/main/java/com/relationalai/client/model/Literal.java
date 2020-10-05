/*
 * Delve Client SDK
 * This is a Client SDK for Delve API
 *
 * The version of the OpenAPI document: 1.0.7
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

/**
 * Literal
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class Literal extends SyntaxNode {
  public static final String SERIALIZED_NAME_MISSING = "missing";
  @SerializedName(SERIALIZED_NAME_MISSING)
  private Boolean missing = false;

  public static final String SERIALIZED_NAME_RANGE = "range";
  @SerializedName(SERIALIZED_NAME_RANGE)
  private Range range;

  public static final String SERIALIZED_NAME_VALUE = "value";
  @SerializedName(SERIALIZED_NAME_VALUE)
  private String value = "";

  public Literal() {
    this.type = this.getClass().getSimpleName();
  }

  public Literal missing(Boolean missing) {
    
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


  public Literal range(Range range) {
    
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


  public Literal value(String value) {
    
    this.value = value;
    return this;
  }

   /**
   * Get value
   * @return value
  **/
  @ApiModelProperty(required = true, value = "")

  public String getValue() {
    return value;
  }


  public void setValue(String value) {
    this.value = value;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Literal literal = (Literal) o;
    return Objects.equals(this.missing, literal.missing) &&
        Objects.equals(this.range, literal.range) &&
        Objects.equals(this.value, literal.value) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(missing, range, value, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Literal {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    missing: ").append(toIndentedString(missing)).append("\n");
    sb.append("    range: ").append(toIndentedString(range)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
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

