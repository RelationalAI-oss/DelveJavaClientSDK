

# Transaction

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**abort** | **Boolean** |  | 
**actions** | [**List&lt;LabeledAction&gt;**](LabeledAction.md) |  |  [optional]
**dbname** | **String** |  | 
**debugLevel** | **Integer** |  |  [optional]
**mode** | [**ModeEnum**](#ModeEnum) |  | 
**nowaitDurable** | **Boolean** |  | 
**readonly** | **Boolean** |  | 
**sourceDbname** | **String** |  |  [optional]
**version** | **Integer** |  |  [optional]
**type** | [**TypeEnum**](#TypeEnum) |  | 



## Enum: ModeEnum

Name | Value
---- | -----
OPEN | &quot;OPEN&quot;
CREATE | &quot;CREATE&quot;
CREATE_OVERWRITE | &quot;CREATE_OVERWRITE&quot;
OPEN_OR_CREATE | &quot;OPEN_OR_CREATE&quot;
CLONE | &quot;CLONE&quot;
CLONE_OVERWRITE | &quot;CLONE_OVERWRITE&quot;



## Enum: TypeEnum

Name | Value
---- | -----
TRANSACTION | &quot;Transaction&quot;



