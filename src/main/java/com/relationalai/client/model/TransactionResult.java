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


package com.relationalai.client.model;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.relationalai.client.model.AbstractProblem;
import com.relationalai.client.model.LabeledActionResult;
import com.relationalai.client.model.Relation;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * TransactionResult
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class TransactionResult {
  public static final String SERIALIZED_NAME_ABORTED = "aborted";
  @SerializedName(SERIALIZED_NAME_ABORTED)
  private Boolean aborted = false;

  public static final String SERIALIZED_NAME_ACTIONS = "actions";
  @SerializedName(SERIALIZED_NAME_ACTIONS)
  private List<LabeledActionResult> actions = null;

  public static final String SERIALIZED_NAME_DEBUG_LEVEL = "debug_level";
  @SerializedName(SERIALIZED_NAME_DEBUG_LEVEL)
  private Integer debugLevel = 0;

  public static final String SERIALIZED_NAME_OUTPUT = "output";
  @SerializedName(SERIALIZED_NAME_OUTPUT)
  private List<Relation> output = null;

  public static final String SERIALIZED_NAME_PROBLEMS = "problems";
  @SerializedName(SERIALIZED_NAME_PROBLEMS)
  private List<AbstractProblem> problems = null;

  /**
   * Gets or Sets type
   */
  @JsonAdapter(TypeEnum.Adapter.class)
  public enum TypeEnum {
    TRANSACTIONRESULT("TransactionResult");

    private String value;

    TypeEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static TypeEnum fromValue(String value) {
      for (TypeEnum b : TypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<TypeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final TypeEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public TypeEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return TypeEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_TYPE = "type";
  @SerializedName(SERIALIZED_NAME_TYPE)
  private TypeEnum type = TypeEnum.TRANSACTIONRESULT;


  public TransactionResult aborted(Boolean aborted) {
    
    this.aborted = aborted;
    return this;
  }

   /**
   * Get aborted
   * @return aborted
  **/
  @ApiModelProperty(required = true, value = "")

  public Boolean getAborted() {
    return aborted;
  }


  public void setAborted(Boolean aborted) {
    this.aborted = aborted;
  }


  public TransactionResult actions(List<LabeledActionResult> actions) {
    
    this.actions = actions;
    return this;
  }

  public TransactionResult addActionsItem(LabeledActionResult actionsItem) {
    if (this.actions == null) {
      this.actions = new ArrayList<LabeledActionResult>();
    }
    this.actions.add(actionsItem);
    return this;
  }

   /**
   * Get actions
   * @return actions
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public List<LabeledActionResult> getActions() {
    return actions;
  }


  public void setActions(List<LabeledActionResult> actions) {
    this.actions = actions;
  }


  public TransactionResult debugLevel(Integer debugLevel) {
    
    this.debugLevel = debugLevel;
    return this;
  }

   /**
   * Get debugLevel
   * @return debugLevel
  **/
  @ApiModelProperty(required = true, value = "")

  public Integer getDebugLevel() {
    return debugLevel;
  }


  public void setDebugLevel(Integer debugLevel) {
    this.debugLevel = debugLevel;
  }


  public TransactionResult output(List<Relation> output) {
    
    this.output = output;
    return this;
  }

  public TransactionResult addOutputItem(Relation outputItem) {
    if (this.output == null) {
      this.output = new ArrayList<Relation>();
    }
    this.output.add(outputItem);
    return this;
  }

   /**
   * Get output
   * @return output
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public List<Relation> getOutput() {
    return output;
  }


  public void setOutput(List<Relation> output) {
    this.output = output;
  }


  public TransactionResult problems(List<AbstractProblem> problems) {
    
    this.problems = problems;
    return this;
  }

  public TransactionResult addProblemsItem(AbstractProblem problemsItem) {
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


  public TransactionResult type(TypeEnum type) {
    
    this.type = type;
    return this;
  }

   /**
   * Get type
   * @return type
  **/
  @ApiModelProperty(required = true, value = "")

  public TypeEnum getType() {
    return type;
  }


  public void setType(TypeEnum type) {
    this.type = type;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TransactionResult transactionResult = (TransactionResult) o;
    return Objects.equals(this.aborted, transactionResult.aborted) &&
        Objects.equals(this.actions, transactionResult.actions) &&
        Objects.equals(this.debugLevel, transactionResult.debugLevel) &&
        Objects.equals(this.output, transactionResult.output) &&
        Objects.equals(this.problems, transactionResult.problems) &&
        Objects.equals(this.type, transactionResult.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(aborted, actions, debugLevel, output, problems, type);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TransactionResult {\n");
    sb.append("    aborted: ").append(toIndentedString(aborted)).append("\n");
    sb.append("    actions: ").append(toIndentedString(actions)).append("\n");
    sb.append("    debugLevel: ").append(toIndentedString(debugLevel)).append("\n");
    sb.append("    output: ").append(toIndentedString(output)).append("\n");
    sb.append("    problems: ").append(toIndentedString(problems)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
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

