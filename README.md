# Delve Java Client SDK

Delve Client SDK
- API version: 1.0.3

This is a Client SDK for Delve API

  For more information, please visit [https://github.com/RelationalAI-oss/DelveJavaClientSDK](https://github.com/RelationalAI-oss/DelveJavaClientSDK)

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
  <groupId>com.relationalai</groupId>
  <artifactId>delve-java-client-sdk</artifactId>
  <version>1.0.3</version>
  <scope>compile</scope>
</dependency>
```

### Gradle users

Add this dependency to your project's build file:

```groovy
compile "com.relationalai:delve-java-client-sdk:1.0.3"
```

### Getting libraries using Nix

```shell
nix-shell -p openjdk11 maven -I nixpkgs=channel:nixos-20.03
```

### Others

At first generate the JAR by executing:

```shell
mvn clean package
```

Then manually install the following JARs:

* `target/delve-java-client-sdk-1.0.3.jar`
* `target/lib/*.jar`

## Recommendation

It's recommended to create an instance of `Connection` per thread in a multithreaded environment to avoid any potential issues.

## Licensing

Delve Java Client SDK is licensed under the Apache License, Version 2.0.

## Author

[Mohammad Dashti](mailto:mohammad.dashti[at]relational[dot]ai)
