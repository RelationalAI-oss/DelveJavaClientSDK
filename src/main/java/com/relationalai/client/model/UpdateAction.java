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
import com.relationalai.client.model.Action;
import com.relationalai.client.model.PairAnyValueAnyValue;
import com.relationalai.client.model.RelKey;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * UpdateAction
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class UpdateAction extends Action {
  public static final String SERIALIZED_NAME_DELTA = "delta";
  @SerializedName(SERIALIZED_NAME_DELTA)
  private List<PairAnyValueAnyValue> delta = null;

  public static final String SERIALIZED_NAME_REL = "rel";
  @SerializedName(SERIALIZED_NAME_REL)
  private RelKey rel;

  public static final String SERIALIZED_NAME_UPDATES = "updates";
  @SerializedName(SERIALIZED_NAME_UPDATES)
  private List<PairAnyValueAnyValue> updates = null;

  public UpdateAction() {
    this.type = this.getClass().getSimpleName();
  }

  public UpdateAction delta(List<PairAnyValueAnyValue> delta) {
    
    this.delta = delta;
    return this;
  }

  public UpdateAction addDeltaItem(PairAnyValueAnyValue deltaItem) {
    if (this.delta == null) {
      this.delta = new ArrayList<PairAnyValueAnyValue>();
    }
    this.delta.add(deltaItem);
    return this;
  }

   /**
   * Get delta
   * @return delta
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public List<PairAnyValueAnyValue> getDelta() {
    return delta;
  }


  public void setDelta(List<PairAnyValueAnyValue> delta) {
    this.delta = delta;
  }


  public UpdateAction rel(RelKey rel) {
    
    this.rel = rel;
    return this;
  }

   /**
   * Get rel
   * @return rel
  **/
  @ApiModelProperty(required = true, value = "")

  public RelKey getRel() {
    return rel;
  }


  public void setRel(RelKey rel) {
    this.rel = rel;
  }


  public UpdateAction updates(List<PairAnyValueAnyValue> updates) {
    
    this.updates = updates;
    return this;
  }

  public UpdateAction addUpdatesItem(PairAnyValueAnyValue updatesItem) {
    if (this.updates == null) {
      this.updates = new ArrayList<PairAnyValueAnyValue>();
    }
    this.updates.add(updatesItem);
    return this;
  }

   /**
   * Get updates
   * @return updates
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public List<PairAnyValueAnyValue> getUpdates() {
    return updates;
  }


  public void setUpdates(List<PairAnyValueAnyValue> updates) {
    this.updates = updates;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UpdateAction updateAction = (UpdateAction) o;
    return Objects.equals(this.delta, updateAction.delta) &&
        Objects.equals(this.rel, updateAction.rel) &&
        Objects.equals(this.updates, updateAction.updates) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(delta, rel, updates, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdateAction {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    delta: ").append(toIndentedString(delta)).append("\n");
    sb.append("    rel: ").append(toIndentedString(rel)).append("\n");
    sb.append("    updates: ").append(toIndentedString(updates)).append("\n");
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

