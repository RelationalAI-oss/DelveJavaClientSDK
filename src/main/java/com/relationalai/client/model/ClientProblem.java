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
import com.relationalai.client.model.AbstractProblem;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

/**
 * ClientProblem
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class ClientProblem extends AbstractProblem {
  public static final String SERIALIZED_NAME_ERROR_CODE = "error_code";
  @SerializedName(SERIALIZED_NAME_ERROR_CODE)
  private String errorCode = "";

  public static final String SERIALIZED_NAME_IS_ERROR = "is_error";
  @SerializedName(SERIALIZED_NAME_IS_ERROR)
  private Boolean isError = false;

  public static final String SERIALIZED_NAME_IS_EXCEPTION = "is_exception";
  @SerializedName(SERIALIZED_NAME_IS_EXCEPTION)
  private Boolean isException = false;

  public static final String SERIALIZED_NAME_MESSAGE = "message";
  @SerializedName(SERIALIZED_NAME_MESSAGE)
  private String message = "";

  public static final String SERIALIZED_NAME_PATH = "path";
  @SerializedName(SERIALIZED_NAME_PATH)
  private String path = "";

  public static final String SERIALIZED_NAME_REPORT = "report";
  @SerializedName(SERIALIZED_NAME_REPORT)
  private String report = "";

  public ClientProblem() {
    this.type = this.getClass().getSimpleName();
  }

  public ClientProblem errorCode(String errorCode) {
    
    this.errorCode = errorCode;
    return this;
  }

   /**
   * Get errorCode
   * @return errorCode
  **/
  @ApiModelProperty(required = true, value = "")

  public String getErrorCode() {
    return errorCode;
  }


  public void setErrorCode(String errorCode) {
    this.errorCode = errorCode;
  }


  public ClientProblem isError(Boolean isError) {
    
    this.isError = isError;
    return this;
  }

   /**
   * Get isError
   * @return isError
  **/
  @ApiModelProperty(required = true, value = "")

  public Boolean getIsError() {
    return isError;
  }


  public void setIsError(Boolean isError) {
    this.isError = isError;
  }


  public ClientProblem isException(Boolean isException) {
    
    this.isException = isException;
    return this;
  }

   /**
   * Get isException
   * @return isException
  **/
  @ApiModelProperty(required = true, value = "")

  public Boolean getIsException() {
    return isException;
  }


  public void setIsException(Boolean isException) {
    this.isException = isException;
  }


  public ClientProblem message(String message) {
    
    this.message = message;
    return this;
  }

   /**
   * Get message
   * @return message
  **/
  @ApiModelProperty(required = true, value = "")

  public String getMessage() {
    return message;
  }


  public void setMessage(String message) {
    this.message = message;
  }


  public ClientProblem path(String path) {
    
    this.path = path;
    return this;
  }

   /**
   * Get path
   * @return path
  **/
  @ApiModelProperty(required = true, value = "")

  public String getPath() {
    return path;
  }


  public void setPath(String path) {
    this.path = path;
  }


  public ClientProblem report(String report) {
    
    this.report = report;
    return this;
  }

   /**
   * Get report
   * @return report
  **/
  @ApiModelProperty(required = true, value = "")

  public String getReport() {
    return report;
  }


  public void setReport(String report) {
    this.report = report;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ClientProblem clientProblem = (ClientProblem) o;
    return Objects.equals(this.errorCode, clientProblem.errorCode) &&
        Objects.equals(this.isError, clientProblem.isError) &&
        Objects.equals(this.isException, clientProblem.isException) &&
        Objects.equals(this.message, clientProblem.message) &&
        Objects.equals(this.path, clientProblem.path) &&
        Objects.equals(this.report, clientProblem.report) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(errorCode, isError, isException, message, path, report, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ClientProblem {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    errorCode: ").append(toIndentedString(errorCode)).append("\n");
    sb.append("    isError: ").append(toIndentedString(isError)).append("\n");
    sb.append("    isException: ").append(toIndentedString(isException)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    path: ").append(toIndentedString(path)).append("\n");
    sb.append("    report: ").append(toIndentedString(report)).append("\n");
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

