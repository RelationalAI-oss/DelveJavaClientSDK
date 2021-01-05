/*
 * Delve Client SDK
 * This is a Client SDK for Delve API
 *
 * The version of the OpenAPI document: 1.1.6
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
 * ListEdbAction
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class ListEdbAction extends Action {
  public static final String SERIALIZED_NAME_RELNAME = "relname";
  @SerializedName(SERIALIZED_NAME_RELNAME)
  private String relname;

  public ListEdbAction() {
    this.type = this.getClass().getSimpleName();
  }

  public ListEdbAction relname(String relname) {
    
    this.relname = relname;
    return this;
  }

   /**
   * Get relname
   * @return relname
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getRelname() {
    return relname;
  }


  public void setRelname(String relname) {
    this.relname = relname;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ListEdbAction listEdbAction = (ListEdbAction) o;
    return Objects.equals(this.relname, listEdbAction.relname) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(relname, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ListEdbAction {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    relname: ").append(toIndentedString(relname)).append("\n");
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

