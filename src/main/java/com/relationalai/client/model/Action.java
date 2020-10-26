/*
 * Delve Client SDK
 * This is a Client SDK for Delve API
 *
 * The version of the OpenAPI document: 1.0.9
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
import com.relationalai.client.model.CardinalityAction;
import com.relationalai.client.model.CollectProblemsAction;
import com.relationalai.client.model.ImportAction;
import com.relationalai.client.model.InstallAction;
import com.relationalai.client.model.ListEdbAction;
import com.relationalai.client.model.ListSourceAction;
import com.relationalai.client.model.LoadDataAction;
import com.relationalai.client.model.ModifyWorkspaceAction;
import com.relationalai.client.model.ParseAction;
import com.relationalai.client.model.QueryAction;
import com.relationalai.client.model.SetOptionsAction;
import com.relationalai.client.model.StatusAction;
import com.relationalai.client.model.UpdateAction;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

/**
 * Action
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class Action {
  public static final String SERIALIZED_NAME_TYPE = "type";
  @SerializedName(SERIALIZED_NAME_TYPE)
  protected String type = "";

  public Action() {
    this.type = this.getClass().getSimpleName();
  }

  public Action type(String type) {
    
    this.type = type;
    return this;
  }

   /**
   * Get type
   * @return type
  **/
  @ApiModelProperty(required = true, value = "")

  public String getType() {
    return type;
  }


  public void setType(String type) {
    this.type = type;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Action action = (Action) o;
    return Objects.equals(this.type, action.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Action {\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
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

