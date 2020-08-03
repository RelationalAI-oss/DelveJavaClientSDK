

# Transaction

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**dbname** | **String** |  |  [optional]
**mode** | [**ModeEnum**](#ModeEnum) |  | 
**readonly** | **Boolean** |  |  [optional]
**actions** | [**List&lt;LabeledAction&gt;**](LabeledAction.md) |  |  [optional]
**abort** | **Boolean** |  |  [optional]
**objtp** | [**ObjtpEnum**](#ObjtpEnum) |  | 



## Enum: ModeEnum

Name | Value
---- | -----
OPEN | &quot;OPEN&quot;
CREATE | &quot;CREATE&quot;
CREATE_OVERWRITE | &quot;CREATE_OVERWRITE&quot;
OPEN_OR_CREATE | &quot;OPEN_OR_CREATE&quot;



## Enum: ObjtpEnum

Name | Value
---- | -----
TRANSACTION | &quot;Transaction&quot;



