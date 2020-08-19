

# Transaction

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**abort** | **Boolean** |  |  [optional]
**actions** | [**List&lt;LabeledAction&gt;**](LabeledAction.md) |  |  [optional]
**dbname** | **String** |  |  [optional]
**mode** | [**ModeEnum**](#ModeEnum) |  | 
**readonly** | **Boolean** |  |  [optional]
**sourceDbname** | **String** |  |  [optional]
**type** | [**TypeEnum**](#TypeEnum) |  | 



## Enum: ModeEnum

Name | Value
---- | -----
OPEN | &quot;OPEN&quot;
CREATE | &quot;CREATE&quot;
CREATE_OVERWRITE | &quot;CREATE_OVERWRITE&quot;
OPEN_OR_CREATE | &quot;OPEN_OR_CREATE&quot;
BRANCH | &quot;BRANCH&quot;



## Enum: TypeEnum

Name | Value
---- | -----
TRANSACTION | &quot;Transaction&quot;



