/*
 * Delve Client SDK
 * This is a Client SDK for Delve API
 *
 * The version of the OpenAPI document: 1.0.2
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
import java.util.ArrayList;
import java.util.List;

/**
 * ModifyWorkspaceAction
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class ModifyWorkspaceAction extends Action {
  public static final String SERIALIZED_NAME_DELETE_EDB = "delete_edb";
  @SerializedName(SERIALIZED_NAME_DELETE_EDB)
  private String deleteEdb;

  public static final String SERIALIZED_NAME_DELETE_SOURCE = "delete_source";
  @SerializedName(SERIALIZED_NAME_DELETE_SOURCE)
  private List<String> deleteSource = null;

  public static final String SERIALIZED_NAME_ENABLE_LIBRARY = "enable_library";
  @SerializedName(SERIALIZED_NAME_ENABLE_LIBRARY)
  private String enableLibrary;

  public ModifyWorkspaceAction() {
    this.type = this.getClass().getSimpleName();
  }

  public ModifyWorkspaceAction deleteEdb(String deleteEdb) {
    
    this.deleteEdb = deleteEdb;
    return this;
  }

   /**
   * Get deleteEdb
   * @return deleteEdb
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getDeleteEdb() {
    return deleteEdb;
  }


  public void setDeleteEdb(String deleteEdb) {
    this.deleteEdb = deleteEdb;
  }


  public ModifyWorkspaceAction deleteSource(List<String> deleteSource) {
    
    this.deleteSource = deleteSource;
    return this;
  }

  public ModifyWorkspaceAction addDeleteSourceItem(String deleteSourceItem) {
    if (this.deleteSource == null) {
      this.deleteSource = new ArrayList<String>();
    }
    this.deleteSource.add(deleteSourceItem);
    return this;
  }

   /**
   * Get deleteSource
   * @return deleteSource
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public List<String> getDeleteSource() {
    return deleteSource;
  }


  public void setDeleteSource(List<String> deleteSource) {
    this.deleteSource = deleteSource;
  }


  public ModifyWorkspaceAction enableLibrary(String enableLibrary) {
    
    this.enableLibrary = enableLibrary;
    return this;
  }

   /**
   * Get enableLibrary
   * @return enableLibrary
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getEnableLibrary() {
    return enableLibrary;
  }


  public void setEnableLibrary(String enableLibrary) {
    this.enableLibrary = enableLibrary;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ModifyWorkspaceAction modifyWorkspaceAction = (ModifyWorkspaceAction) o;
    return Objects.equals(this.deleteEdb, modifyWorkspaceAction.deleteEdb) &&
        Objects.equals(this.deleteSource, modifyWorkspaceAction.deleteSource) &&
        Objects.equals(this.enableLibrary, modifyWorkspaceAction.enableLibrary) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(deleteEdb, deleteSource, enableLibrary, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ModifyWorkspaceAction {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    deleteEdb: ").append(toIndentedString(deleteEdb)).append("\n");
    sb.append("    deleteSource: ").append(toIndentedString(deleteSource)).append("\n");
    sb.append("    enableLibrary: ").append(toIndentedString(enableLibrary)).append("\n");
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

