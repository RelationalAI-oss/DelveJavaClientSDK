/*
 * Delve Client SDK
 * This is a Client SDK for Delve API
 *
 * The version of the OpenAPI document: 1.0.4
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
 * CardinalityAction
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class CardinalityAction extends Action {
  public static final String SERIALIZED_NAME_RELNAME = "relname";
  @SerializedName(SERIALIZED_NAME_RELNAME)
  private String relname;

  public CardinalityAction() {
    this.type = this.getClass().getSimpleName();
  }

  public CardinalityAction relname(String relname) {
    
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
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CardinalityAction cardinalityAction = (CardinalityAction) o;
    return Objects.equals(this.relname, cardinalityAction.relname) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(relname, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CardinalityAction {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    relname: ").append(toIndentedString(relname)).append("\n");
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

