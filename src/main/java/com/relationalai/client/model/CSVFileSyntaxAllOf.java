/*
 * Delve Client SDK
 * This is a Client SDK for Delve API
 *
 * The version of the OpenAPI document: 1.2.0
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
import java.util.ArrayList;
import java.util.List;

/**
 * CSVFileSyntaxAllOf
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class CSVFileSyntaxAllOf {
  public static final String SERIALIZED_NAME_DATAROW = "datarow";
  @SerializedName(SERIALIZED_NAME_DATAROW)
  private Integer datarow = 0;

  public static final String SERIALIZED_NAME_DELIM = "delim";
  @SerializedName(SERIALIZED_NAME_DELIM)
  private String delim = "";

  public static final String SERIALIZED_NAME_ESCAPECHAR = "escapechar";
  @SerializedName(SERIALIZED_NAME_ESCAPECHAR)
  private String escapechar = "";

  public static final String SERIALIZED_NAME_HEADER = "header";
  @SerializedName(SERIALIZED_NAME_HEADER)
  private List<String> header = null;

  public static final String SERIALIZED_NAME_HEADER_ROW = "header_row";
  @SerializedName(SERIALIZED_NAME_HEADER_ROW)
  private Integer headerRow = 0;

  public static final String SERIALIZED_NAME_IGNOREREPEATED = "ignorerepeated";
  @SerializedName(SERIALIZED_NAME_IGNOREREPEATED)
  private Boolean ignorerepeated = false;

  public static final String SERIALIZED_NAME_MISSINGSTRINGS = "missingstrings";
  @SerializedName(SERIALIZED_NAME_MISSINGSTRINGS)
  private List<String> missingstrings = null;

  public static final String SERIALIZED_NAME_NORMALIZENAMES = "normalizenames";
  @SerializedName(SERIALIZED_NAME_NORMALIZENAMES)
  private Boolean normalizenames = false;

  public static final String SERIALIZED_NAME_QUOTECHAR = "quotechar";
  @SerializedName(SERIALIZED_NAME_QUOTECHAR)
  private String quotechar = "";


  public CSVFileSyntaxAllOf datarow(Integer datarow) {
    
    this.datarow = datarow;
    return this;
  }

   /**
   * Get datarow
   * @return datarow
  **/
  @ApiModelProperty(required = true, value = "")

  public Integer getDatarow() {
    return datarow;
  }


  public void setDatarow(Integer datarow) {
    this.datarow = datarow;
  }


  public CSVFileSyntaxAllOf delim(String delim) {
    
    this.delim = delim;
    return this;
  }

   /**
   * Get delim
   * @return delim
  **/
  @ApiModelProperty(required = true, value = "")

  public String getDelim() {
    return delim;
  }


  public void setDelim(String delim) {
    this.delim = delim;
  }


  public CSVFileSyntaxAllOf escapechar(String escapechar) {
    
    this.escapechar = escapechar;
    return this;
  }

   /**
   * Get escapechar
   * @return escapechar
  **/
  @ApiModelProperty(required = true, value = "")

  public String getEscapechar() {
    return escapechar;
  }


  public void setEscapechar(String escapechar) {
    this.escapechar = escapechar;
  }


  public CSVFileSyntaxAllOf header(List<String> header) {
    
    this.header = header;
    return this;
  }

  public CSVFileSyntaxAllOf addHeaderItem(String headerItem) {
    if (this.header == null) {
      this.header = new ArrayList<String>();
    }
    this.header.add(headerItem);
    return this;
  }

   /**
   * Get header
   * @return header
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public List<String> getHeader() {
    return header;
  }


  public void setHeader(List<String> header) {
    this.header = header;
  }


  public CSVFileSyntaxAllOf headerRow(Integer headerRow) {
    
    this.headerRow = headerRow;
    return this;
  }

   /**
   * Get headerRow
   * @return headerRow
  **/
  @ApiModelProperty(required = true, value = "")

  public Integer getHeaderRow() {
    return headerRow;
  }


  public void setHeaderRow(Integer headerRow) {
    this.headerRow = headerRow;
  }


  public CSVFileSyntaxAllOf ignorerepeated(Boolean ignorerepeated) {
    
    this.ignorerepeated = ignorerepeated;
    return this;
  }

   /**
   * Get ignorerepeated
   * @return ignorerepeated
  **/
  @ApiModelProperty(required = true, value = "")

  public Boolean getIgnorerepeated() {
    return ignorerepeated;
  }


  public void setIgnorerepeated(Boolean ignorerepeated) {
    this.ignorerepeated = ignorerepeated;
  }


  public CSVFileSyntaxAllOf missingstrings(List<String> missingstrings) {
    
    this.missingstrings = missingstrings;
    return this;
  }

  public CSVFileSyntaxAllOf addMissingstringsItem(String missingstringsItem) {
    if (this.missingstrings == null) {
      this.missingstrings = new ArrayList<String>();
    }
    this.missingstrings.add(missingstringsItem);
    return this;
  }

   /**
   * Get missingstrings
   * @return missingstrings
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public List<String> getMissingstrings() {
    return missingstrings;
  }


  public void setMissingstrings(List<String> missingstrings) {
    this.missingstrings = missingstrings;
  }


  public CSVFileSyntaxAllOf normalizenames(Boolean normalizenames) {
    
    this.normalizenames = normalizenames;
    return this;
  }

   /**
   * Get normalizenames
   * @return normalizenames
  **/
  @ApiModelProperty(required = true, value = "")

  public Boolean getNormalizenames() {
    return normalizenames;
  }


  public void setNormalizenames(Boolean normalizenames) {
    this.normalizenames = normalizenames;
  }


  public CSVFileSyntaxAllOf quotechar(String quotechar) {
    
    this.quotechar = quotechar;
    return this;
  }

   /**
   * Get quotechar
   * @return quotechar
  **/
  @ApiModelProperty(required = true, value = "")

  public String getQuotechar() {
    return quotechar;
  }


  public void setQuotechar(String quotechar) {
    this.quotechar = quotechar;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CSVFileSyntaxAllOf csVFileSyntaxAllOf = (CSVFileSyntaxAllOf) o;
    return Objects.equals(this.datarow, csVFileSyntaxAllOf.datarow) &&
        Objects.equals(this.delim, csVFileSyntaxAllOf.delim) &&
        Objects.equals(this.escapechar, csVFileSyntaxAllOf.escapechar) &&
        Objects.equals(this.header, csVFileSyntaxAllOf.header) &&
        Objects.equals(this.headerRow, csVFileSyntaxAllOf.headerRow) &&
        Objects.equals(this.ignorerepeated, csVFileSyntaxAllOf.ignorerepeated) &&
        Objects.equals(this.missingstrings, csVFileSyntaxAllOf.missingstrings) &&
        Objects.equals(this.normalizenames, csVFileSyntaxAllOf.normalizenames) &&
        Objects.equals(this.quotechar, csVFileSyntaxAllOf.quotechar);
  }

  @Override
  public int hashCode() {
    return Objects.hash(datarow, delim, escapechar, header, headerRow, ignorerepeated, missingstrings, normalizenames, quotechar);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CSVFileSyntaxAllOf {\n");
    sb.append("    datarow: ").append(toIndentedString(datarow)).append("\n");
    sb.append("    delim: ").append(toIndentedString(delim)).append("\n");
    sb.append("    escapechar: ").append(toIndentedString(escapechar)).append("\n");
    sb.append("    header: ").append(toIndentedString(header)).append("\n");
    sb.append("    headerRow: ").append(toIndentedString(headerRow)).append("\n");
    sb.append("    ignorerepeated: ").append(toIndentedString(ignorerepeated)).append("\n");
    sb.append("    missingstrings: ").append(toIndentedString(missingstrings)).append("\n");
    sb.append("    normalizenames: ").append(toIndentedString(normalizenames)).append("\n");
    sb.append("    quotechar: ").append(toIndentedString(quotechar)).append("\n");
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

