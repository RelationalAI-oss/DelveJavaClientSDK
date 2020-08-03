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
import org.openapitools.client.model.ConstantType;
import org.openapitools.client.model.WrappedType;

/**
 * DBType
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-08-03T02:10:24.995237-07:00[America/Vancouver]")
public class DBType {
  public static final String SERIALIZED_NAME_OBJTP = "objtp";
  @SerializedName(SERIALIZED_NAME_OBJTP)
  protected String objtp = "";

  public DBType() {
    this.objtp = this.getClass().getSimpleName();
  }

  public DBType objtp(String objtp) {
    
    this.objtp = objtp;
    return this;
  }

   /**
   * Get objtp
   * @return objtp
  **/
  @ApiModelProperty(required = true, value = "")

  public String getObjtp() {
    return objtp;
  }


  public void setObjtp(String objtp) {
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
    DBType dbType = (DBType) o;
    return Objects.equals(this.objtp, dbType.objtp);
  }

  @Override
  public int hashCode() {
    return Objects.hash(objtp);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DBType {\n");
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

