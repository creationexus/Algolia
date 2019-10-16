# client-algolia

## Requirements

Building the API client library requires [Maven](https://maven.apache.org/) to be installed.

## Installation

To install the API client library to your local Maven repository, simply execute:

```shell
mvn install
```

To deploy it to a remote Maven repository instead, configure the settings of the repository and execute:

```shell
mvn deploy
```

Refer to the [official documentation](https://maven.apache.org/plugins/maven-deploy-plugin/usage.html) for more information.

### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
    <groupId>cl.ingerencia.client.algolia</groupId>
    <artifactId>client-algolia</artifactId>
    <version>1.0.0</version>
    <scope>compile</scope>
</dependency>
```

### Gradle users

Add this dependency to your project's build file:

```groovy
compile "cl.ingerencia.client.algolia:client-algolia:1.0.0"
```

### Others

At first generate the JAR by executing:

    mvn package

Then manually install the following JARs:

* target/client-algolia-1.0.0.jar
* target/lib/*.jar

## Getting Started

Please follow the [installation](#installation) instruction and execute the following Java code:

```java

import cl.ingerencia.client.algolia.swagger.*;
import cl.ingerencia.client.algolia.swagger.auth.*;
import cl.ingerencia.client.algolia.swagger.codegen.model.*;
import cl.ingerencia.client.algolia.swagger.codegen.api.ArticulosApi;

import java.io.File;
import java.util.*;

public class ArticulosApiExample {

    public static void main(String[] args) {
        
        ArticulosApi apiInstance = new ArticulosApi();
        String query = "query_example"; // String | 
        String page = "page_example"; // String | 
        try {
            Articulos result = apiInstance.articulos(query, page);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ArticulosApi#articulos");
            e.printStackTrace();
        }
    }
}

```

## Documentation for API Endpoints

All URIs are relative to *https://hn.algolia.com/api/v1*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*ArticulosApi* | [**articulos**](docs/ArticulosApi.md#articulos) | **GET** /search_by_date | Lista de articulos a procesar


## Documentation for Models

 - [Articulos](docs/Articulos.md)
 - [Hit](docs/Hit.md)


## Documentation for Authorization

All endpoints do not require authorization.
Authentication schemes defined for the API:

## Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issues.

## Author

random@deltaquo.com

