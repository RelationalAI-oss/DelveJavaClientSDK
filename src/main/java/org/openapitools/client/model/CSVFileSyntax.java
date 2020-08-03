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
import org.openapitools.client.model.FileSyntax;

/**
 * CSVFileSyntax
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-08-03T02:10:24.995237-07:00[America/Vancouver]")
public class CSVFileSyntax extends FileSyntax {
  public static final String SERIALIZED_NAME_HEADER = "header";
  @SerializedName(SERIALIZED_NAME_HEADER)
  private List<String> header = null;

  public static final String SERIALIZED_NAME_HEADER_ROW = "header_row";
  @SerializedName(SERIALIZED_NAME_HEADER_ROW)
  private Integer headerRow = null;

  public static final String SERIALIZED_NAME_NORMALIZENAMES = "normalizenames";
  @SerializedName(SERIALIZED_NAME_NORMALIZENAMES)
  private Boolean normalizenames = false;

  public static final String SERIALIZED_NAME_DATAROW = "datarow";
  @SerializedName(SERIALIZED_NAME_DATAROW)
  private Integer datarow = null;

  public static final String SERIALIZED_NAME_MISSINGSTRINGS = "missingstrings";
  @SerializedName(SERIALIZED_NAME_MISSINGSTRINGS)
  private List<String> missingstrings = null;

  public static final String SERIALIZED_NAME_DELIM = "delim";
  @SerializedName(SERIALIZED_NAME_DELIM)
  private String delim = "";

  public static final String SERIALIZED_NAME_IGNOREREPEATED = "ignorerepeated";
  @SerializedName(SERIALIZED_NAME_IGNOREREPEATED)
  private Boolean ignorerepeated = false;

  public static final String SERIALIZED_NAME_QUOTECHAR = "quotechar";
  @SerializedName(SERIALIZED_NAME_QUOTECHAR)
  private String quotechar = "";

  public static final String SERIALIZED_NAME_ESCAPECHAR = "escapechar";
  @SerializedName(SERIALIZED_NAME_ESCAPECHAR)
  private String escapechar = "";

  public CSVFileSyntax() {
    this.objtp = this.getClass().getSimpleName();
  }

  public CSVFileSyntax header(List<String> header) {
    
    this.header = header;
    return this;
  }

  public CSVFileSyntax addHeaderItem(String headerItem) {
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


  public CSVFileSyntax headerRow(Integer headerRow) {
    
    this.headerRow = headerRow;
    return this;
  }

   /**
   * Get headerRow
   * @return headerRow
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Integer getHeaderRow() {
    return headerRow;
  }


  public void setHeaderRow(Integer headerRow) {
    this.headerRow = headerRow;
  }


  public CSVFileSyntax normalizenames(Boolean normalizenames) {
    
    this.normalizenames = normalizenames;
    return this;
  }

   /**
   * Get normalizenames
   * @return normalizenames
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Boolean getNormalizenames() {
    return normalizenames;
  }


  public void setNormalizenames(Boolean normalizenames) {
    this.normalizenames = normalizenames;
  }


  public CSVFileSyntax datarow(Integer datarow) {
    
    this.datarow = datarow;
    return this;
  }

   /**
   * Get datarow
   * @return datarow
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Integer getDatarow() {
    return datarow;
  }


  public void setDatarow(Integer datarow) {
    this.datarow = datarow;
  }


  public CSVFileSyntax missingstrings(List<String> missingstrings) {
    
    this.missingstrings = missingstrings;
    return this;
  }

  public CSVFileSyntax addMissingstringsItem(String missingstringsItem) {
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


  public CSVFileSyntax delim(String delim) {
    
    this.delim = delim;
    return this;
  }

   /**
   * Get delim
   * @return delim
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getDelim() {
    return delim;
  }


  public void setDelim(String delim) {
    this.delim = delim;
  }


  public CSVFileSyntax ignorerepeated(Boolean ignorerepeated) {
    
    this.ignorerepeated = ignorerepeated;
    return this;
  }

   /**
   * Get ignorerepeated
   * @return ignorerepeated
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Boolean getIgnorerepeated() {
    return ignorerepeated;
  }


  public void setIgnorerepeated(Boolean ignorerepeated) {
    this.ignorerepeated = ignorerepeated;
  }


  public CSVFileSyntax quotechar(String quotechar) {
    
    this.quotechar = quotechar;
    return this;
  }

   /**
   * Get quotechar
   * @return quotechar
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getQuotechar() {
    return quotechar;
  }


  public void setQuotechar(String quotechar) {
    this.quotechar = quotechar;
  }


  public CSVFileSyntax escapechar(String escapechar) {
    
    this.escapechar = escapechar;
    return this;
  }

   /**
   * Get escapechar
   * @return escapechar
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getEscapechar() {
    return escapechar;
  }


  public void setEscapechar(String escapechar) {
    this.escapechar = escapechar;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CSVFileSyntax csVFileSyntax = (CSVFileSyntax) o;
    return Objects.equals(this.header, csVFileSyntax.header) &&
        Objects.equals(this.headerRow, csVFileSyntax.headerRow) &&
        Objects.equals(this.normalizenames, csVFileSyntax.normalizenames) &&
        Objects.equals(this.datarow, csVFileSyntax.datarow) &&
        Objects.equals(this.missingstrings, csVFileSyntax.missingstrings) &&
        Objects.equals(this.delim, csVFileSyntax.delim) &&
        Objects.equals(this.ignorerepeated, csVFileSyntax.ignorerepeated) &&
        Objects.equals(this.quotechar, csVFileSyntax.quotechar) &&
        Objects.equals(this.escapechar, csVFileSyntax.escapechar) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(header, headerRow, normalizenames, datarow, missingstrings, delim, ignorerepeated, quotechar, escapechar, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CSVFileSyntax {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    header: ").append(toIndentedString(header)).append("\n");
    sb.append("    headerRow: ").append(toIndentedString(headerRow)).append("\n");
    sb.append("    normalizenames: ").append(toIndentedString(normalizenames)).append("\n");
    sb.append("    datarow: ").append(toIndentedString(datarow)).append("\n");
    sb.append("    missingstrings: ").append(toIndentedString(missingstrings)).append("\n");
    sb.append("    delim: ").append(toIndentedString(delim)).append("\n");
    sb.append("    ignorerepeated: ").append(toIndentedString(ignorerepeated)).append("\n");
    sb.append("    quotechar: ").append(toIndentedString(quotechar)).append("\n");
    sb.append("    escapechar: ").append(toIndentedString(escapechar)).append("\n");
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

