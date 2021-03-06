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
import com.relationalai.client.model.RelKey;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * ListEdbActionResultAllOf
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class ListEdbActionResultAllOf {
  public static final String SERIALIZED_NAME_RELS = "rels";
  @SerializedName(SERIALIZED_NAME_RELS)
  private List<RelKey> rels = null;


  public ListEdbActionResultAllOf rels(List<RelKey> rels) {
    
    this.rels = rels;
    return this;
  }

  public ListEdbActionResultAllOf addRelsItem(RelKey relsItem) {
    if (this.rels == null) {
      this.rels = new ArrayList<RelKey>();
    }
    this.rels.add(relsItem);
    return this;
  }

   /**
   * Get rels
   * @return rels
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public List<RelKey> getRels() {
    return rels;
  }


  public void setRels(List<RelKey> rels) {
    this.rels = rels;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ListEdbActionResultAllOf listEdbActionResultAllOf = (ListEdbActionResultAllOf) o;
    return Objects.equals(this.rels, listEdbActionResultAllOf.rels);
  }

  @Override
  public int hashCode() {
    return Objects.hash(rels);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ListEdbActionResultAllOf {\n");
    sb.append("    rels: ").append(toIndentedString(rels)).append("\n");
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

