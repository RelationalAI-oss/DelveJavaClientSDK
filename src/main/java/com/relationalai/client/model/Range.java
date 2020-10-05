/*
 * Delve Client SDK
 * This is a Client SDK for Delve API
 *
 * The version of the OpenAPI document: 1.0.7
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
import com.relationalai.client.model.Area;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

/**
 * Range
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class Range {
  public static final String SERIALIZED_NAME_AREA = "area";
  @SerializedName(SERIALIZED_NAME_AREA)
  private Area area;

  public static final String SERIALIZED_NAME_END_BYTE = "end_byte";
  @SerializedName(SERIALIZED_NAME_END_BYTE)
  private Integer endByte = 0;

  public static final String SERIALIZED_NAME_INPUT = "input";
  @SerializedName(SERIALIZED_NAME_INPUT)
  private Object input = null;

  public static final String SERIALIZED_NAME_START_BYTE = "start_byte";
  @SerializedName(SERIALIZED_NAME_START_BYTE)
  private Integer startByte = 0;

  /**
   * Gets or Sets type
   */
  @JsonAdapter(TypeEnum.Adapter.class)
  public enum TypeEnum {
    RANGE("Range");

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
  private TypeEnum type = TypeEnum.RANGE;


  public Range area(Area area) {
    
    this.area = area;
    return this;
  }

   /**
   * Get area
   * @return area
  **/
  @ApiModelProperty(required = true, value = "")

  public Area getArea() {
    return area;
  }


  public void setArea(Area area) {
    this.area = area;
  }


  public Range endByte(Integer endByte) {
    
    this.endByte = endByte;
    return this;
  }

   /**
   * Get endByte
   * @return endByte
  **/
  @ApiModelProperty(required = true, value = "")

  public Integer getEndByte() {
    return endByte;
  }


  public void setEndByte(Integer endByte) {
    this.endByte = endByte;
  }


  public Range input(Object input) {
    
    this.input = input;
    return this;
  }

   /**
   * Get input
   * @return input
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Object getInput() {
    return input;
  }


  public void setInput(Object input) {
    this.input = input;
  }


  public Range startByte(Integer startByte) {
    
    this.startByte = startByte;
    return this;
  }

   /**
   * Get startByte
   * @return startByte
  **/
  @ApiModelProperty(required = true, value = "")

  public Integer getStartByte() {
    return startByte;
  }


  public void setStartByte(Integer startByte) {
    this.startByte = startByte;
  }


  public Range type(TypeEnum type) {
    
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
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Range range = (Range) o;
    return Objects.equals(this.area, range.area) &&
        Objects.equals(this.endByte, range.endByte) &&
        Objects.equals(this.input, range.input) &&
        Objects.equals(this.startByte, range.startByte) &&
        Objects.equals(this.type, range.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(area, endByte, input, startByte, type);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Range {\n");
    sb.append("    area: ").append(toIndentedString(area)).append("\n");
    sb.append("    endByte: ").append(toIndentedString(endByte)).append("\n");
    sb.append("    input: ").append(toIndentedString(input)).append("\n");
    sb.append("    startByte: ").append(toIndentedString(startByte)).append("\n");
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

