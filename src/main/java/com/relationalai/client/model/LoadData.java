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
import com.relationalai.client.model.FileSchema;
import com.relationalai.client.model.FileSyntax;
import com.relationalai.client.model.Integration;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

/**
 * LoadData
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class LoadData {
  public static final String SERIALIZED_NAME_CONTENT_TYPE = "content_type";
  @SerializedName(SERIALIZED_NAME_CONTENT_TYPE)
  private String contentType = "";

  public static final String SERIALIZED_NAME_DATA = "data";
  @SerializedName(SERIALIZED_NAME_DATA)
  private String data;

  public static final String SERIALIZED_NAME_FILE_SCHEMA = "file_schema";
  @SerializedName(SERIALIZED_NAME_FILE_SCHEMA)
  private FileSchema fileSchema;

  public static final String SERIALIZED_NAME_FILE_SYNTAX = "file_syntax";
  @SerializedName(SERIALIZED_NAME_FILE_SYNTAX)
  private FileSyntax fileSyntax;

  public static final String SERIALIZED_NAME_INTEGRATION = "integration";
  @SerializedName(SERIALIZED_NAME_INTEGRATION)
  private Integration integration;

  public static final String SERIALIZED_NAME_KEY = "key";
  @SerializedName(SERIALIZED_NAME_KEY)
  private Object key = null;

  public static final String SERIALIZED_NAME_PATH = "path";
  @SerializedName(SERIALIZED_NAME_PATH)
  private String path;

  /**
   * Gets or Sets type
   */
  @JsonAdapter(TypeEnum.Adapter.class)
  public enum TypeEnum {
    LOADDATA("LoadData");

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
  private TypeEnum type = TypeEnum.LOADDATA;


  public LoadData contentType(String contentType) {
    
    this.contentType = contentType;
    return this;
  }

   /**
   * Get contentType
   * @return contentType
  **/
  @ApiModelProperty(required = true, value = "")

  public String getContentType() {
    return contentType;
  }


  public void setContentType(String contentType) {
    this.contentType = contentType;
  }


  public LoadData data(String data) {
    
    this.data = data;
    return this;
  }

   /**
   * Get data
   * @return data
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getData() {
    return data;
  }


  public void setData(String data) {
    this.data = data;
  }


  public LoadData fileSchema(FileSchema fileSchema) {
    
    this.fileSchema = fileSchema;
    return this;
  }

   /**
   * Get fileSchema
   * @return fileSchema
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public FileSchema getFileSchema() {
    return fileSchema;
  }


  public void setFileSchema(FileSchema fileSchema) {
    this.fileSchema = fileSchema;
  }


  public LoadData fileSyntax(FileSyntax fileSyntax) {
    
    this.fileSyntax = fileSyntax;
    return this;
  }

   /**
   * Get fileSyntax
   * @return fileSyntax
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public FileSyntax getFileSyntax() {
    return fileSyntax;
  }


  public void setFileSyntax(FileSyntax fileSyntax) {
    this.fileSyntax = fileSyntax;
  }


  public LoadData integration(Integration integration) {
    
    this.integration = integration;
    return this;
  }

   /**
   * Get integration
   * @return integration
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Integration getIntegration() {
    return integration;
  }


  public void setIntegration(Integration integration) {
    this.integration = integration;
  }


  public LoadData key(Object key) {
    
    this.key = key;
    return this;
  }

   /**
   * Get key
   * @return key
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(required = true, value = "")

  public Object getKey() {
    return key;
  }


  public void setKey(Object key) {
    this.key = key;
  }


  public LoadData path(String path) {
    
    this.path = path;
    return this;
  }

   /**
   * Get path
   * @return path
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getPath() {
    return path;
  }


  public void setPath(String path) {
    this.path = path;
  }


  public LoadData type(TypeEnum type) {
    
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
    LoadData loadData = (LoadData) o;
    return Objects.equals(this.contentType, loadData.contentType) &&
        Objects.equals(this.data, loadData.data) &&
        Objects.equals(this.fileSchema, loadData.fileSchema) &&
        Objects.equals(this.fileSyntax, loadData.fileSyntax) &&
        Objects.equals(this.integration, loadData.integration) &&
        Objects.equals(this.key, loadData.key) &&
        Objects.equals(this.path, loadData.path) &&
        Objects.equals(this.type, loadData.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(contentType, data, fileSchema, fileSyntax, integration, key, path, type);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LoadData {\n");
    sb.append("    contentType: ").append(toIndentedString(contentType)).append("\n");
    sb.append("    data: ").append(toIndentedString(data)).append("\n");
    sb.append("    fileSchema: ").append(toIndentedString(fileSchema)).append("\n");
    sb.append("    fileSyntax: ").append(toIndentedString(fileSyntax)).append("\n");
    sb.append("    integration: ").append(toIndentedString(integration)).append("\n");
    sb.append("    key: ").append(toIndentedString(key)).append("\n");
    sb.append("    path: ").append(toIndentedString(path)).append("\n");
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

