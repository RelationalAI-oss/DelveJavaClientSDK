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
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

/**
 * PairAnyValueAnyValue
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class PairAnyValueAnyValue {
  public static final String SERIALIZED_NAME_FIRST = "first";
  @SerializedName(SERIALIZED_NAME_FIRST)
  private Object first = null;

  public static final String SERIALIZED_NAME_SECOND = "second";
  @SerializedName(SERIALIZED_NAME_SECOND)
  private Object second = null;

  /**
   * Gets or Sets type
   */
  @JsonAdapter(TypeEnum.Adapter.class)
  public enum TypeEnum {
    PAIR_ANYVALUE_ANYVALUE_("Pair_AnyValue_AnyValue_");

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
  private TypeEnum type = TypeEnum.PAIR_ANYVALUE_ANYVALUE_;


  public PairAnyValueAnyValue first(Object first) {
    
    this.first = first;
    return this;
  }

   /**
   * Get first
   * @return first
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Object getFirst() {
    return first;
  }


  public void setFirst(Object first) {
    this.first = first;
  }


  public PairAnyValueAnyValue second(Object second) {
    
    this.second = second;
    return this;
  }

   /**
   * Get second
   * @return second
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Object getSecond() {
    return second;
  }


  public void setSecond(Object second) {
    this.second = second;
  }


  public PairAnyValueAnyValue type(TypeEnum type) {
    
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
    PairAnyValueAnyValue pairAnyValueAnyValue = (PairAnyValueAnyValue) o;
    return Objects.equals(this.first, pairAnyValueAnyValue.first) &&
        Objects.equals(this.second, pairAnyValueAnyValue.second) &&
        Objects.equals(this.type, pairAnyValueAnyValue.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(first, second, type);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PairAnyValueAnyValue {\n");
    sb.append("    first: ").append(toIndentedString(first)).append("\n");
    sb.append("    second: ").append(toIndentedString(second)).append("\n");
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

