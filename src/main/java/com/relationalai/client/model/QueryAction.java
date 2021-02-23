/*
 * Delve Client SDK
 * This is a Client SDK for Delve API
 *
 * The version of the OpenAPI document: 1.1.3
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
import com.relationalai.client.model.QueryActionAllOf;
import com.relationalai.client.model.Relation;
import com.relationalai.client.model.Source;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * QueryAction
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class QueryAction extends Action {
  public static final String SERIALIZED_NAME_INPUTS = "inputs";
  @SerializedName(SERIALIZED_NAME_INPUTS)
  private List<Relation> inputs = null;

  public static final String SERIALIZED_NAME_OUTPUTS = "outputs";
  @SerializedName(SERIALIZED_NAME_OUTPUTS)
  private List<String> outputs = null;

  public static final String SERIALIZED_NAME_PERSIST = "persist";
  @SerializedName(SERIALIZED_NAME_PERSIST)
  private List<String> persist = null;

  public static final String SERIALIZED_NAME_SOURCE = "source";
  @SerializedName(SERIALIZED_NAME_SOURCE)
  private Source source;

  public QueryAction() {
    this.type = this.getClass().getSimpleName();
  }

  public QueryAction inputs(List<Relation> inputs) {
    
    this.inputs = inputs;
    return this;
  }

  public QueryAction addInputsItem(Relation inputsItem) {
    if (this.inputs == null) {
      this.inputs = new ArrayList<Relation>();
    }
    this.inputs.add(inputsItem);
    return this;
  }

   /**
   * Get inputs
   * @return inputs
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public List<Relation> getInputs() {
    return inputs;
  }


  public void setInputs(List<Relation> inputs) {
    this.inputs = inputs;
  }


  public QueryAction outputs(List<String> outputs) {
    
    this.outputs = outputs;
    return this;
  }

  public QueryAction addOutputsItem(String outputsItem) {
    if (this.outputs == null) {
      this.outputs = new ArrayList<String>();
    }
    this.outputs.add(outputsItem);
    return this;
  }

   /**
   * Get outputs
   * @return outputs
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public List<String> getOutputs() {
    return outputs;
  }


  public void setOutputs(List<String> outputs) {
    this.outputs = outputs;
  }


  public QueryAction persist(List<String> persist) {
    
    this.persist = persist;
    return this;
  }

  public QueryAction addPersistItem(String persistItem) {
    if (this.persist == null) {
      this.persist = new ArrayList<String>();
    }
    this.persist.add(persistItem);
    return this;
  }

   /**
   * Get persist
   * @return persist
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public List<String> getPersist() {
    return persist;
  }


  public void setPersist(List<String> persist) {
    this.persist = persist;
  }


  public QueryAction source(Source source) {
    
    this.source = source;
    return this;
  }

   /**
   * Get source
   * @return source
  **/
  @ApiModelProperty(required = true, value = "")

  public Source getSource() {
    return source;
  }


  public void setSource(Source source) {
    this.source = source;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    QueryAction queryAction = (QueryAction) o;
    return Objects.equals(this.inputs, queryAction.inputs) &&
        Objects.equals(this.outputs, queryAction.outputs) &&
        Objects.equals(this.persist, queryAction.persist) &&
        Objects.equals(this.source, queryAction.source) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(inputs, outputs, persist, source, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class QueryAction {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    inputs: ").append(toIndentedString(inputs)).append("\n");
    sb.append("    outputs: ").append(toIndentedString(outputs)).append("\n");
    sb.append("    persist: ").append(toIndentedString(persist)).append("\n");
    sb.append("    source: ").append(toIndentedString(source)).append("\n");
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

