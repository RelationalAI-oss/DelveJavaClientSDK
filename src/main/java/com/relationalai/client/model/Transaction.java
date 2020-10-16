/*
 * Delve Client SDK
 * This is a Client SDK for Delve API
 *
 * The version of the OpenAPI document: 1.0.11
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
import com.relationalai.client.model.LabeledAction;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Transaction
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class Transaction {
  public static final String SERIALIZED_NAME_ABORT = "abort";
  @SerializedName(SERIALIZED_NAME_ABORT)
  private Boolean abort = false;

  public static final String SERIALIZED_NAME_ACTIONS = "actions";
  @SerializedName(SERIALIZED_NAME_ACTIONS)
  private List<LabeledAction> actions = null;

  public static final String SERIALIZED_NAME_DBNAME = "dbname";
  @SerializedName(SERIALIZED_NAME_DBNAME)
  private String dbname = "";

  public static final String SERIALIZED_NAME_DEBUG_LEVEL = "debug_level";
  @SerializedName(SERIALIZED_NAME_DEBUG_LEVEL)
  private Integer debugLevel;

  /**
   * Gets or Sets mode
   */
  @JsonAdapter(ModeEnum.Adapter.class)
  public enum ModeEnum {
    OPEN("OPEN"),
    
    CREATE("CREATE"),
    
    CREATE_OVERWRITE("CREATE_OVERWRITE"),
    
    OPEN_OR_CREATE("OPEN_OR_CREATE"),
    
    CLONE("CLONE"),
    
    CLONE_OVERWRITE("CLONE_OVERWRITE");

    private String value;

    ModeEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static ModeEnum fromValue(String value) {
      for (ModeEnum b : ModeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<ModeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final ModeEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public ModeEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return ModeEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_MODE = "mode";
  @SerializedName(SERIALIZED_NAME_MODE)
  private ModeEnum mode = ModeEnum.OPEN;

  public static final String SERIALIZED_NAME_READONLY = "readonly";
  @SerializedName(SERIALIZED_NAME_READONLY)
  private Boolean readonly = false;

  public static final String SERIALIZED_NAME_SOURCE_DBNAME = "source_dbname";
  @SerializedName(SERIALIZED_NAME_SOURCE_DBNAME)
  private String sourceDbname;

  public static final String SERIALIZED_NAME_VERSION = "version";
  @SerializedName(SERIALIZED_NAME_VERSION)
  private Integer version;

  /**
   * Gets or Sets type
   */
  @JsonAdapter(TypeEnum.Adapter.class)
  public enum TypeEnum {
    TRANSACTION("Transaction");

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
  private TypeEnum type = TypeEnum.TRANSACTION;


  public Transaction abort(Boolean abort) {
    
    this.abort = abort;
    return this;
  }

   /**
   * Get abort
   * @return abort
  **/
  @ApiModelProperty(required = true, value = "")

  public Boolean getAbort() {
    return abort;
  }


  public void setAbort(Boolean abort) {
    this.abort = abort;
  }


  public Transaction actions(List<LabeledAction> actions) {
    
    this.actions = actions;
    return this;
  }

  public Transaction addActionsItem(LabeledAction actionsItem) {
    if (this.actions == null) {
      this.actions = new ArrayList<LabeledAction>();
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

  public List<LabeledAction> getActions() {
    return actions;
  }


  public void setActions(List<LabeledAction> actions) {
    this.actions = actions;
  }


  public Transaction dbname(String dbname) {
    
    this.dbname = dbname;
    return this;
  }

   /**
   * Get dbname
   * @return dbname
  **/
  @ApiModelProperty(required = true, value = "")

  public String getDbname() {
    return dbname;
  }


  public void setDbname(String dbname) {
    this.dbname = dbname;
  }


  public Transaction debugLevel(Integer debugLevel) {
    
    this.debugLevel = debugLevel;
    return this;
  }

   /**
   * Get debugLevel
   * @return debugLevel
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Integer getDebugLevel() {
    return debugLevel;
  }


  public void setDebugLevel(Integer debugLevel) {
    this.debugLevel = debugLevel;
  }


  public Transaction mode(ModeEnum mode) {
    
    this.mode = mode;
    return this;
  }

   /**
   * Get mode
   * @return mode
  **/
  @ApiModelProperty(required = true, value = "")

  public ModeEnum getMode() {
    return mode;
  }


  public void setMode(ModeEnum mode) {
    this.mode = mode;
  }


  public Transaction readonly(Boolean readonly) {
    
    this.readonly = readonly;
    return this;
  }

   /**
   * Get readonly
   * @return readonly
  **/
  @ApiModelProperty(required = true, value = "")

  public Boolean getReadonly() {
    return readonly;
  }


  public void setReadonly(Boolean readonly) {
    this.readonly = readonly;
  }


  public Transaction sourceDbname(String sourceDbname) {
    
    this.sourceDbname = sourceDbname;
    return this;
  }

   /**
   * Get sourceDbname
   * @return sourceDbname
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getSourceDbname() {
    return sourceDbname;
  }


  public void setSourceDbname(String sourceDbname) {
    this.sourceDbname = sourceDbname;
  }


  public Transaction version(Integer version) {
    
    this.version = version;
    return this;
  }

   /**
   * Get version
   * @return version
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Integer getVersion() {
    return version;
  }


  public void setVersion(Integer version) {
    this.version = version;
  }


  public Transaction type(TypeEnum type) {
    
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
    Transaction transaction = (Transaction) o;
    return Objects.equals(this.abort, transaction.abort) &&
        Objects.equals(this.actions, transaction.actions) &&
        Objects.equals(this.dbname, transaction.dbname) &&
        Objects.equals(this.debugLevel, transaction.debugLevel) &&
        Objects.equals(this.mode, transaction.mode) &&
        Objects.equals(this.readonly, transaction.readonly) &&
        Objects.equals(this.sourceDbname, transaction.sourceDbname) &&
        Objects.equals(this.version, transaction.version) &&
        Objects.equals(this.type, transaction.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(abort, actions, dbname, debugLevel, mode, readonly, sourceDbname, version, type);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Transaction {\n");
    sb.append("    abort: ").append(toIndentedString(abort)).append("\n");
    sb.append("    actions: ").append(toIndentedString(actions)).append("\n");
    sb.append("    dbname: ").append(toIndentedString(dbname)).append("\n");
    sb.append("    debugLevel: ").append(toIndentedString(debugLevel)).append("\n");
    sb.append("    mode: ").append(toIndentedString(mode)).append("\n");
    sb.append("    readonly: ").append(toIndentedString(readonly)).append("\n");
    sb.append("    sourceDbname: ").append(toIndentedString(sourceDbname)).append("\n");
    sb.append("    version: ").append(toIndentedString(version)).append("\n");
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

