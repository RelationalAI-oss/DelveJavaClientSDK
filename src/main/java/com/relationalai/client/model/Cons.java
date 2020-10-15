/*
 * Delve Client SDK
 * This is a Client SDK for Delve API
 *
 * The version of the OpenAPI document: 1.1.0
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
 * Cons
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class Cons extends LinkedList {
  public static final String SERIALIZED_NAME_HEAD = "head";
  @SerializedName(SERIALIZED_NAME_HEAD)
  private SyntaxNode head;

  public static final String SERIALIZED_NAME_TAIL = "tail";
  @SerializedName(SERIALIZED_NAME_TAIL)
  private LinkedList tail;

  public Cons() {
    this.type = this.getClass().getSimpleName();
  }

  public Cons head(SyntaxNode head) {
    
    this.head = head;
    return this;
  }

   /**
   * Get head
   * @return head
  **/
  @ApiModelProperty(required = true, value = "")

  public SyntaxNode getHead() {
    return head;
  }


  public void setHead(SyntaxNode head) {
    this.head = head;
  }


  public Cons tail(LinkedList tail) {
    
    this.tail = tail;
    return this;
  }

   /**
   * Get tail
   * @return tail
  **/
  @ApiModelProperty(required = true, value = "")

  public LinkedList getTail() {
    return tail;
  }


  public void setTail(LinkedList tail) {
    this.tail = tail;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Cons cons = (Cons) o;
    return Objects.equals(this.head, cons.head) &&
        Objects.equals(this.tail, cons.tail) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(head, tail, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Cons {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    head: ").append(toIndentedString(head)).append("\n");
    sb.append("    tail: ").append(toIndentedString(tail)).append("\n");
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

