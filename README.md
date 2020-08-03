# openapi-java-client

Delve Client SDK
- API version: 1.0.0

This is a Client SDK for Delve API

  For more information, please visit [https://www.relational.ai/support](https://www.relational.ai/support)

*Automatically generated by the [OpenAPI Generator](https://openapi-generator.tech)*


## Requirements

Building the API client library requires:
1. Java 1.7+
2. Maven/Gradle

## Installation

To install the API client library to your local Maven repository, simply execute:

```shell
mvn clean install
```

To deploy it to a remote Maven repository instead, configure the settings of the repository and execute:

```shell
mvn clean deploy
```

Refer to the [OSSRH Guide](http://central.sonatype.org/pages/ossrh-guide.html) for more information.

### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
  <groupId>ai.relational</groupId>
  <artifactId>openapi-java-client</artifactId>
  <version>1.0.0</version>
  <scope>compile</scope>
</dependency>
```

### Gradle users

Add this dependency to your project's build file:

```groovy
compile "ai.relational:openapi-java-client:1.0.0"
```

### Others

At first generate the JAR by executing:

```shell
mvn clean package
```

Then manually install the following JARs:

* `target/openapi-java-client-1.0.0.jar`
* `target/lib/*.jar`

## Getting Started

Please follow the [installation](#installation) instruction and execute the following Java code:

```java

// Import classes:
import ai.relational.client.ApiClient;
import ai.relational.client.ApiException;
import ai.relational.client.Configuration;
import ai.relational.client.models.*;
import ai.relational.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://127.0.0.1:8010");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    Transaction transaction = new Transaction(); // Transaction | Optional description in *Markdown*
    try {
      TransactionResult result = apiInstance.transactionPost(transaction);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#transactionPost");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}

```

## Documentation for API Endpoints

All URIs are relative to *http://127.0.0.1:8010*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*DefaultApi* | [**transactionPost**](docs/DefaultApi.md#transactionPost) | **POST** /transaction | Issues a transaction to be executed


## Documentation for Models

 - [AbstractProblem](docs/AbstractProblem.md)
 - [Action](docs/Action.md)
 - [ActionResult](docs/ActionResult.md)
 - [AnyValue](docs/AnyValue.md)
 - [Appl](docs/Appl.md)
 - [Area](docs/Area.md)
 - [CSVFileSchema](docs/CSVFileSchema.md)
 - [CSVFileSyntax](docs/CSVFileSyntax.md)
 - [CardinalityAction](docs/CardinalityAction.md)
 - [CardinalityActionResult](docs/CardinalityActionResult.md)
 - [ClientProblem](docs/ClientProblem.md)
 - [CollectProblemsAction](docs/CollectProblemsAction.md)
 - [CollectProblemsActionResult](docs/CollectProblemsActionResult.md)
 - [Cons](docs/Cons.md)
 - [ConstantType](docs/ConstantType.md)
 - [DBType](docs/DBType.md)
 - [DictElementRelKeyAnyValue](docs/DictElementRelKeyAnyValue.md)
 - [ExceptionProblem](docs/ExceptionProblem.md)
 - [FileSchema](docs/FileSchema.md)
 - [FileSyntax](docs/FileSyntax.md)
 - [ICViolation](docs/ICViolation.md)
 - [ImportAction](docs/ImportAction.md)
 - [ImportActionResult](docs/ImportActionResult.md)
 - [InstallAction](docs/InstallAction.md)
 - [InstallActionResult](docs/InstallActionResult.md)
 - [IntegrityConstraintProblem](docs/IntegrityConstraintProblem.md)
 - [IntegrityConstraintViolation](docs/IntegrityConstraintViolation.md)
 - [JSONFileSyntax](docs/JSONFileSyntax.md)
 - [LabeledAction](docs/LabeledAction.md)
 - [LabeledActionResult](docs/LabeledActionResult.md)
 - [LinkedList](docs/LinkedList.md)
 - [ListEdbAction](docs/ListEdbAction.md)
 - [ListEdbActionResult](docs/ListEdbActionResult.md)
 - [ListSourceAction](docs/ListSourceAction.md)
 - [ListSourceActionResult](docs/ListSourceActionResult.md)
 - [Literal](docs/Literal.md)
 - [LoadData](docs/LoadData.md)
 - [LoadDataAction](docs/LoadDataAction.md)
 - [LoadDataActionResult](docs/LoadDataActionResult.md)
 - [ModifyWorkspaceAction](docs/ModifyWorkspaceAction.md)
 - [ModifyWorkspaceActionResult](docs/ModifyWorkspaceActionResult.md)
 - [Nil](docs/Nil.md)
 - [OutputProblem](docs/OutputProblem.md)
 - [PairAnyValueAnyValue](docs/PairAnyValueAnyValue.md)
 - [PairRelKeyAnyValue](docs/PairRelKeyAnyValue.md)
 - [ParseAction](docs/ParseAction.md)
 - [ParseActionResult](docs/ParseActionResult.md)
 - [PersistProblem](docs/PersistProblem.md)
 - [Point](docs/Point.md)
 - [QueryAction](docs/QueryAction.md)
 - [QueryActionResult](docs/QueryActionResult.md)
 - [Range](docs/Range.md)
 - [RelDict](docs/RelDict.md)
 - [RelKey](docs/RelKey.md)
 - [SetOptionsAction](docs/SetOptionsAction.md)
 - [SetOptionsActionResult](docs/SetOptionsActionResult.md)
 - [Source](docs/Source.md)
 - [SyntaxError](docs/SyntaxError.md)
 - [SyntaxNode](docs/SyntaxNode.md)
 - [Token](docs/Token.md)
 - [Transaction](docs/Transaction.md)
 - [TransactionResult](docs/TransactionResult.md)
 - [UndefinedError](docs/UndefinedError.md)
 - [UpdateAction](docs/UpdateAction.md)
 - [UpdateActionResult](docs/UpdateActionResult.md)
 - [WorkspaceLoadProblem](docs/WorkspaceLoadProblem.md)
 - [WrappedType](docs/WrappedType.md)


## Documentation for Authorization

All endpoints do not require authorization.
Authentication schemes defined for the API:

## Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issues.

## Author

support@relational.ai

