/*
 * Delve Client SDK
 * This is a Client SDK for Delve API
 *
 * The version of the OpenAPI document: 1.0.13
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
import com.relationalai.client.model.AbstractProblem;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

/**
 * PersistProblem
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class PersistProblem extends AbstractProblem {
  public static final String SERIALIZED_NAME_EXCEPTION = "exception";
  @SerializedName(SERIALIZED_NAME_EXCEPTION)
  private String exception = "";

  public static final String SERIALIZED_NAME_EXCEPTION_STACKTRACE = "exception_stacktrace";
  @SerializedName(SERIALIZED_NAME_EXCEPTION_STACKTRACE)
  private String exceptionStacktrace;

  public PersistProblem() {
    this.type = this.getClass().getSimpleName();
  }

  public PersistProblem exception(String exception) {
    
    this.exception = exception;
    return this;
  }

   /**
   * Get exception
   * @return exception
  **/
  @ApiModelProperty(required = true, value = "")

  public String getException() {
    return exception;
  }


  public void setException(String exception) {
    this.exception = exception;
  }


  public PersistProblem exceptionStacktrace(String exceptionStacktrace) {
    
    this.exceptionStacktrace = exceptionStacktrace;
    return this;
  }

   /**
   * Get exceptionStacktrace
   * @return exceptionStacktrace
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getExceptionStacktrace() {
    return exceptionStacktrace;
  }


  public void setExceptionStacktrace(String exceptionStacktrace) {
    this.exceptionStacktrace = exceptionStacktrace;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PersistProblem persistProblem = (PersistProblem) o;
    return Objects.equals(this.exception, persistProblem.exception) &&
        Objects.equals(this.exceptionStacktrace, persistProblem.exceptionStacktrace) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(exception, exceptionStacktrace, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PersistProblem {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    exception: ").append(toIndentedString(exception)).append("\n");
    sb.append("    exceptionStacktrace: ").append(toIndentedString(exceptionStacktrace)).append("\n");
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

