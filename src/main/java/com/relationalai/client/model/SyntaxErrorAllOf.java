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
import com.relationalai.client.model.LinkedList;
import com.relationalai.client.model.SyntaxNode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

/**
 * SyntaxErrorAllOf
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class SyntaxErrorAllOf {
  public static final String SERIALIZED_NAME_NEXT = "next";
  @SerializedName(SERIALIZED_NAME_NEXT)
  private SyntaxNode next;

  public static final String SERIALIZED_NAME_NODE = "node";
  @SerializedName(SERIALIZED_NAME_NODE)
  private SyntaxNode node;

  public static final String SERIALIZED_NAME_TRACE = "trace";
  @SerializedName(SERIALIZED_NAME_TRACE)
  private LinkedList trace;


  public SyntaxErrorAllOf next(SyntaxNode next) {
    
    this.next = next;
    return this;
  }

   /**
   * Get next
   * @return next
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public SyntaxNode getNext() {
    return next;
  }


  public void setNext(SyntaxNode next) {
    this.next = next;
  }


  public SyntaxErrorAllOf node(SyntaxNode node) {
    
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


  public SyntaxErrorAllOf trace(LinkedList trace) {
    
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


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SyntaxErrorAllOf syntaxErrorAllOf = (SyntaxErrorAllOf) o;
    return Objects.equals(this.next, syntaxErrorAllOf.next) &&
        Objects.equals(this.node, syntaxErrorAllOf.node) &&
        Objects.equals(this.trace, syntaxErrorAllOf.trace);
  }

  @Override
  public int hashCode() {
    return Objects.hash(next, node, trace);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SyntaxErrorAllOf {\n");
    sb.append("    next: ").append(toIndentedString(next)).append("\n");
    sb.append("    node: ").append(toIndentedString(node)).append("\n");
    sb.append("    trace: ").append(toIndentedString(trace)).append("\n");
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

