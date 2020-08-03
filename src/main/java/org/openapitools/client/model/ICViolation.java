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
import org.openapitools.client.model.RelKey;

/**
 * ICViolation
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class ICViolation {
  public static final String SERIALIZED_NAME_REL_KEY = "rel_key";
  @SerializedName(SERIALIZED_NAME_REL_KEY)
  private RelKey relKey;

  public static final String SERIALIZED_NAME_SOURCE = "source";
  @SerializedName(SERIALIZED_NAME_SOURCE)
  private String source = "";

  /**
   * Gets or Sets objtp
   */
  @JsonAdapter(ObjtpEnum.Adapter.class)
  public enum ObjtpEnum {
    ICVIOLATION("ICViolation");

    private String value;

    ObjtpEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static ObjtpEnum fromValue(String value) {
      for (ObjtpEnum b : ObjtpEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<ObjtpEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final ObjtpEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public ObjtpEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return ObjtpEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_OBJTP = "objtp";
  @SerializedName(SERIALIZED_NAME_OBJTP)
  private ObjtpEnum objtp = ObjtpEnum.ICVIOLATION;


  public ICViolation relKey(RelKey relKey) {
    
    this.relKey = relKey;
    return this;
  }

   /**
   * Get relKey
   * @return relKey
  **/
  @ApiModelProperty(required = true, value = "")

  public RelKey getRelKey() {
    return relKey;
  }


  public void setRelKey(RelKey relKey) {
    this.relKey = relKey;
  }


  public ICViolation source(String source) {
    
    this.source = source;
    return this;
  }

   /**
   * Get source
   * @return source
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getSource() {
    return source;
  }


  public void setSource(String source) {
    this.source = source;
  }


  public ICViolation objtp(ObjtpEnum objtp) {
    
    this.objtp = objtp;
    return this;
  }

   /**
   * Get objtp
   * @return objtp
  **/
  @ApiModelProperty(required = true, value = "")

  public ObjtpEnum getObjtp() {
    return objtp;
  }


  public void setObjtp(ObjtpEnum objtp) {
    this.objtp = objtp;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ICViolation icViolation = (ICViolation) o;
    return Objects.equals(this.relKey, icViolation.relKey) &&
        Objects.equals(this.source, icViolation.source) &&
        Objects.equals(this.objtp, icViolation.objtp);
  }

  @Override
  public int hashCode() {
    return Objects.hash(relKey, source, objtp);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ICViolation {\n");
    sb.append("    relKey: ").append(toIndentedString(relKey)).append("\n");
    sb.append("    source: ").append(toIndentedString(source)).append("\n");
    sb.append("    objtp: ").append(toIndentedString(objtp)).append("\n");
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

