# Delve Java Client SDK

Delve Client SDK
- API version: 1.1.2

This is a Client SDK for Delve API

  For more information, please visit [https://github.com/RelationalAI-oss/DelveJavaClientSDK](https://github.com/RelationalAI-oss/DelveJavaClientSDK)

## Requirements

Building the API client library requires:
1. Open JDK 11+
2. Maven

## Installation

To install the API client library to your local Maven repository, simply execute:

```shell
mvn clean install
```

### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
  <groupId>com.relationalai</groupId>
  <artifactId>delve-java-client-sdk</artifactId>
  <version>1.1.2</version>
</dependency>
```

To point maven to the repo, you also have to specify the `repositoriy` in the `pom.xml`.

```xml
<repositories>
    <repository>
        <id>github</id>
        <name>GitHub RelationalAI-oss Apache Maven Packages</name>
        <url>https://maven.pkg.github.com/RelationalAI-oss/DelveJavaClientSDK</url>
    </repository>
</repositories>
```

The registry access is available through the GitHub api which is protected by an authorisation. So you have ro add the credentials to the Package Registry to your global `settings.xml`:
`USER_HOME\.m2\settings.xml`

```xml
<servers>
    <server>
        <id>github</id>
        <username>YOUR_USERNAME</username>
        <password>YOUR_AUTH_TOKEN</password>
    </server>
</servers>
```

Replace the `YOUR_USERNAME` with your GitHub login name.
Replace the `YOUR_AUTH_TOKEN` with a generated GitHub personal access token:
*GitHub > Settings > Developer Settings > Personal access tokens > Generate new token*:
The token needs at least the read:packages scope. Otherwise you will get a `Not authorized` exception.

### Getting libraries using Nix

You can use the following command:

```shell
nix-shell -p openjdk11 maven -I nixpkgs=channel:nixos-20.03
```

### Others

At first generate the JAR by executing:

```shell
mvn clean package
```

Then manually install the following JARs:

* `target/delve-java-client-sdk-1.1.2.jar`
* `target/lib/*.jar`

## Recommendation

It's recommended to create an instance of `Connection` per thread in a multithreaded environment to avoid any potential issues.

## Licensing

Delve Java Client SDK is licensed under the Apache License, Version 2.0.

## Author

[Mohammad Dashti](mailto:mohammad.dashti[at]relational[dot]ai)
