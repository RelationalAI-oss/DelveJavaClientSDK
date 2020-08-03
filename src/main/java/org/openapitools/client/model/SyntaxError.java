/*
 * Delve Client SDK
 * This is a Client SDK for Delve API
 *
 * The version of the OpenAPI document: 1.0.0
 * Contact: support@relational.ai
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package org.openapitools.client.model;

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
import org.openapitools.client.model.AbstractProblem;
import org.openapitools.client.model.LinkedList;
import org.openapitools.client.model.SyntaxNode;

/**
 * SyntaxError
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-08-03T02:10:24.995237-07:00[America/Vancouver]")
public class SyntaxError extends AbstractProblem {
  public static final String SERIALIZED_NAME_NODE = "node";
  @SerializedName(SERIALIZED_NAME_NODE)
  private SyntaxNode node;

  public static final String SERIALIZED_NAME_TRACE = "trace";
  @SerializedName(SERIALIZED_NAME_TRACE)
  private LinkedList trace;

  public static final String SERIALIZED_NAME_NEXT = "next";
  @SerializedName(SERIALIZED_NAME_NEXT)
  private SyntaxNode next;

  public SyntaxError() {
    this.objtp = this.getClass().getSimpleName();
  }

  public SyntaxError node(SyntaxNode node) {
    
    this.node = node;
    return this;
  }

   /**
   * Get node
   * @return node
  **/
  @ApiModelProperty(required = true, value = "")

  public SyntaxNode getNode() {
    return node;
  }


  public void setNode(SyntaxNode node) {
    this.node = node;
  }


  public SyntaxError trace(LinkedList trace) {
    
    this.trace = trace;
    return this;
  }

   /**
   * Get trace
   * @return trace
  **/
  @ApiModelProperty(required = true, value = "")

  public LinkedList getTrace() {
    return trace;
  }


  public void setTrace(LinkedList trace) {
    this.trace = trace;
  }


  public SyntaxError next(SyntaxNode next) {
    
    this.next = next;
    return this;
  }

   /**
   * Get next
   * @return next
  **/
  @ApiModelProperty(required = true, value = "")

  public SyntaxNode getNext() {
    return next;
  }


  public void setNext(SyntaxNode next) {
    this.next = next;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SyntaxError syntaxError = (SyntaxError) o;
    return Objects.equals(this.node, syntaxError.node) &&
        Objects.equals(this.trace, syntaxError.trace) &&
        Objects.equals(this.next, syntaxError.next) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(node, trace, next, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SyntaxError {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    node: ").append(toIndentedString(node)).append("\n");
    sb.append("    trace: ").append(toIndentedString(trace)).append("\n");
    sb.append("    next: ").append(toIndentedString(next)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

