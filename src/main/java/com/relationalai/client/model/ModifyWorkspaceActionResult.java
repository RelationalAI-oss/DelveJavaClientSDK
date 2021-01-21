/*
 * Delve Client SDK
 * This is a Client SDK for Delve API
 *
 * The version of the OpenAPI document: 1.1.7
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
import com.relationalai.client.model.ActionResult;
import com.relationalai.client.model.RelKey;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * ModifyWorkspaceActionResult
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class ModifyWorkspaceActionResult extends ActionResult {
  public static final String SERIALIZED_NAME_DELETE_EDB_RESULT = "delete_edb_result";
  @SerializedName(SERIALIZED_NAME_DELETE_EDB_RESULT)
  private List<RelKey> deleteEdbResult = null;

  public ModifyWorkspaceActionResult() {
    this.type = this.getClass().getSimpleName();
  }

  public ModifyWorkspaceActionResult deleteEdbResult(List<RelKey> deleteEdbResult) {
    
    this.deleteEdbResult = deleteEdbResult;
    return this;
  }

  public ModifyWorkspaceActionResult addDeleteEdbResultItem(RelKey deleteEdbResultItem) {
    if (this.deleteEdbResult == null) {
      this.deleteEdbResult = new ArrayList<RelKey>();
    }
    this.deleteEdbResult.add(deleteEdbResultItem);
    return this;
  }

   /**
   * Get deleteEdbResult
   * @return deleteEdbResult
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public List<RelKey> getDeleteEdbResult() {
    return deleteEdbResult;
  }


  public void setDeleteEdbResult(List<RelKey> deleteEdbResult) {
    this.deleteEdbResult = deleteEdbResult;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ModifyWorkspaceActionResult modifyWorkspaceActionResult = (ModifyWorkspaceActionResult) o;
    return Objects.equals(this.deleteEdbResult, modifyWorkspaceActionResult.deleteEdbResult) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(deleteEdbResult, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ModifyWorkspaceActionResult {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    deleteEdbResult: ").append(toIndentedString(deleteEdbResult)).append("\n");
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

