/*
 * Delve Client SDK
 * This is a Client SDK for Delve API
 *
 * The version of the OpenAPI document: 1.0.1
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
import com.relationalai.client.model.ICViolation;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * IntegrityConstraintViolation
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class IntegrityConstraintViolation extends AbstractProblem {
  public static final String SERIALIZED_NAME_SOURCES = "sources";
  @SerializedName(SERIALIZED_NAME_SOURCES)
  private List<ICViolation> sources = null;

  public IntegrityConstraintViolation() {
    this.type = this.getClass().getSimpleName();
  }

  public IntegrityConstraintViolation sources(List<ICViolation> sources) {
    
    this.sources = sources;
    return this;
  }

  public IntegrityConstraintViolation addSourcesItem(ICViolation sourcesItem) {
    if (this.sources == null) {
      this.sources = new ArrayList<ICViolation>();
    }
    this.sources.add(sourcesItem);
    return this;
  }

   /**
   * Get sources
   * @return sources
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public List<ICViolation> getSources() {
    return sources;
  }


  public void setSources(List<ICViolation> sources) {
    this.sources = sources;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IntegrityConstraintViolation integrityConstraintViolation = (IntegrityConstraintViolation) o;
    return Objects.equals(this.sources, integrityConstraintViolation.sources) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(sources, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class IntegrityConstraintViolation {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    sources: ").append(toIndentedString(sources)).append("\n");
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

