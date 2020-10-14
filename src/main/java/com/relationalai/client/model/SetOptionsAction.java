/*
 * Delve Client SDK
 * This is a Client SDK for Delve API
 *
 * The version of the OpenAPI document: 1.0.10
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
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

/**
 * SetOptionsAction
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class SetOptionsAction extends Action {
  public static final String SERIALIZED_NAME_ABORT_ON_ERROR = "abort_on_error";
  @SerializedName(SERIALIZED_NAME_ABORT_ON_ERROR)
  private Boolean abortOnError;

  public static final String SERIALIZED_NAME_BROKEN = "broken";
  @SerializedName(SERIALIZED_NAME_BROKEN)
  private Boolean broken;

  public static final String SERIALIZED_NAME_DEBUG = "debug";
  @SerializedName(SERIALIZED_NAME_DEBUG)
  private Boolean debug;

  public static final String SERIALIZED_NAME_DEBUG_TRACE = "debug_trace";
  @SerializedName(SERIALIZED_NAME_DEBUG_TRACE)
  private Boolean debugTrace;

  public static final String SERIALIZED_NAME_SILENT = "silent";
  @SerializedName(SERIALIZED_NAME_SILENT)
  private Boolean silent;

  public SetOptionsAction() {
    this.type = this.getClass().getSimpleName();
  }

  public SetOptionsAction abortOnError(Boolean abortOnError) {
    
    this.abortOnError = abortOnError;
    return this;
  }

   /**
   * Get abortOnError
   * @return abortOnError
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Boolean getAbortOnError() {
    return abortOnError;
  }


  public void setAbortOnError(Boolean abortOnError) {
    this.abortOnError = abortOnError;
  }


  public SetOptionsAction broken(Boolean broken) {
    
    this.broken = broken;
    return this;
  }

   /**
   * Get broken
   * @return broken
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Boolean getBroken() {
    return broken;
  }


  public void setBroken(Boolean broken) {
    this.broken = broken;
  }


  public SetOptionsAction debug(Boolean debug) {
    
    this.debug = debug;
    return this;
  }

   /**
   * Get debug
   * @return debug
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Boolean getDebug() {
    return debug;
  }


  public void setDebug(Boolean debug) {
    this.debug = debug;
  }


  public SetOptionsAction debugTrace(Boolean debugTrace) {
    
    this.debugTrace = debugTrace;
    return this;
  }

   /**
   * Get debugTrace
   * @return debugTrace
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Boolean getDebugTrace() {
    return debugTrace;
  }


  public void setDebugTrace(Boolean debugTrace) {
    this.debugTrace = debugTrace;
  }


  public SetOptionsAction silent(Boolean silent) {
    
    this.silent = silent;
    return this;
  }

   /**
   * Get silent
   * @return silent
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Boolean getSilent() {
    return silent;
  }


  public void setSilent(Boolean silent) {
    this.silent = silent;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SetOptionsAction setOptionsAction = (SetOptionsAction) o;
    return Objects.equals(this.abortOnError, setOptionsAction.abortOnError) &&
        Objects.equals(this.broken, setOptionsAction.broken) &&
        Objects.equals(this.debug, setOptionsAction.debug) &&
        Objects.equals(this.debugTrace, setOptionsAction.debugTrace) &&
        Objects.equals(this.silent, setOptionsAction.silent) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(abortOnError, broken, debug, debugTrace, silent, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SetOptionsAction {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    abortOnError: ").append(toIndentedString(abortOnError)).append("\n");
    sb.append("    broken: ").append(toIndentedString(broken)).append("\n");
    sb.append("    debug: ").append(toIndentedString(debug)).append("\n");
    sb.append("    debugTrace: ").append(toIndentedString(debugTrace)).append("\n");
    sb.append("    silent: ").append(toIndentedString(silent)).append("\n");
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

