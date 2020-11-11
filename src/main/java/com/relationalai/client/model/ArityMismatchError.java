/*
 * Delve Client SDK
 * This is a Client SDK for Delve API
 *
 * The version of the OpenAPI document: 1.1.2
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
 * ArityMismatchError
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class ArityMismatchError extends FrontProblem {
  public static final String SERIALIZED_NAME_MSG = "msg";
  @SerializedName(SERIALIZED_NAME_MSG)
  private String msg = "";

  public static final String SERIALIZED_NAME_NODE = "node";
  @SerializedName(SERIALIZED_NAME_NODE)
  private Object node = null;

  public static final String SERIALIZED_NAME_RANGE = "range";
  @SerializedName(SERIALIZED_NAME_RANGE)
  private Range range;

  public ArityMismatchError() {
    this.type = this.getClass().getSimpleName();
  }

  public ArityMismatchError msg(String msg) {
    
    this.msg = msg;
    return this;
  }

   /**
   * Get msg
   * @return msg
  **/
  @ApiModelProperty(required = true, value = "")

  public String getMsg() {
    return msg;
  }


  public void setMsg(String msg) {
    this.msg = msg;
  }


  public ArityMismatchError node(Object node) {
    
    this.node = node;
    return this;
  }

   /**
   * Get node
   * @return node
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Object getNode() {
    return node;
  }


  public void setNode(Object node) {
    this.node = node;
  }


  public ArityMismatchError range(Range range) {
    
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


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ArityMismatchError arityMismatchError = (ArityMismatchError) o;
    return Objects.equals(this.msg, arityMismatchError.msg) &&
        Objects.equals(this.node, arityMismatchError.node) &&
        Objects.equals(this.range, arityMismatchError.range) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(msg, node, range, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ArityMismatchError {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    msg: ").append(toIndentedString(msg)).append("\n");
    sb.append("    node: ").append(toIndentedString(node)).append("\n");
    sb.append("    range: ").append(toIndentedString(range)).append("\n");
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

