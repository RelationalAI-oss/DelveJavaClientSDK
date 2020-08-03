/*
 * Delve Client SDK
 * This is a Client SDK for Delve API
 *
 * The version of the OpenAPI document: 1.0.0
 * Contact: support@relational.ai
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package org.openapitools.client.model;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.client.model.AbstractProblem;
import org.openapitools.client.model.ActionResult;

/**
 * ParseActionResult
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-08-03T02:10:24.995237-07:00[America/Vancouver]")
public class ParseActionResult extends ActionResult {
  public static final String SERIALIZED_NAME_PROBLEMS = "problems";
  @SerializedName(SERIALIZED_NAME_PROBLEMS)
  private List<AbstractProblem> problems = null;

  public ParseActionResult() {
    this.objtp = this.getClass().getSimpleName();
  }

  public ParseActionResult problems(List<AbstractProblem> problems) {
    
    this.problems = problems;
    return this;
  }

  public ParseActionResult addProblemsItem(AbstractProblem problemsItem) {
    if (this.problems == null) {
      this.problems = new ArrayList<AbstractProblem>();
    }
    this.problems.add(problemsItem);
    return this;
  }

   /**
   * Get problems
   * @return problems
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public List<AbstractProblem> getProblems() {
    return problems;
  }


  public void setProblems(List<AbstractProblem> problems) {
    this.problems = problems;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ParseActionResult parseActionResult = (ParseActionResult) o;
    return Objects.equals(this.problems, parseActionResult.problems) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(problems, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ParseActionResult {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    problems: ").append(toIndentedString(problems)).append("\n");
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

