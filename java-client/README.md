# swagger-java-client

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
    <groupId>io.swagger</groupId>
    <artifactId>swagger-java-client</artifactId>
    <version>1.0.0</version>
    <scope>compile</scope>
</dependency>
```

### Gradle users

Add this dependency to your project's build file:

```groovy
compile "io.swagger:swagger-java-client:1.0.0"
```

### Others

At first generate the JAR by executing:

    mvn package

Then manually install the following JARs:

* target/swagger-java-client-1.0.0.jar
* target/lib/*.jar

## Getting Started

Please follow the [installation](#installation) instruction and execute the following Java code:

```java

import io.swagger.client.*;
import io.swagger.client.auth.*;
import io.swagger.client.model.*;
import io.swagger.client.api.DeviceswifiGetApi;

import java.io.File;
import java.util.*;

public class DeviceswifiGetApiExample {

    public static void main(String[] args) {
        
        DeviceswifiGetApi apiInstance = new DeviceswifiGetApi();
        String filter = "filter_example"; // String | Filtros para deviceswifi. Formato para envio dos filtros \"filter=\"legalNatureCode::VALOR|customerAccountId::VALOR\".  Campos obrigatorios >   Os campos legalNatureCode (Código operadora) e customerAccountId    (Contrato do cliente) são ambos obrigatórios. 
        String xApiVersion = "xApiVersion_example"; // String | Header com a definição da versão da API a ser consumida
        String xMetadata = "xMetadata_example"; // String | Header que define a necessidade do campo metada no response. Permitido \"true\" ou \"false\".
        try {
            DeviceswifiResponseGET result = apiInstance.deviceswifiGet(filter, xApiVersion, xMetadata);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling DeviceswifiGetApi#deviceswifiGet");
            e.printStackTrace();
        }
    }
}

```

## Documentation for API Endpoints

All URIs are relative to *https://apistage.net.com.br/sdp*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*DeviceswifiGetApi* | [**deviceswifiGet**](docs/DeviceswifiGetApi.md#deviceswifiGet) | **GET** /deviceswifi | Recuperar a senha wifi do cliente NET.
*DeviceswifiPatchApi* | [**deviceswifiPatch**](docs/DeviceswifiPatchApi.md#deviceswifiPatch) | **PATCH** /deviceswifi | Alterar a senha wifi do cliente NET.


## Documentation for Models

 - [Body](docs/Body.md)
 - [DeviceswifiData](docs/DeviceswifiData.md)
 - [DeviceswifiResponseGET](docs/DeviceswifiResponseGET.md)
 - [DeviceswifiResponseGETData](docs/DeviceswifiResponseGETData.md)
 - [DeviceswifiResponseGETDataDeviceswifi](docs/DeviceswifiResponseGETDataDeviceswifi.md)
 - [DeviceswifiResponsePATCH](docs/DeviceswifiResponsePATCH.md)
 - [DeviceswifiResponsePATCHData](docs/DeviceswifiResponsePATCHData.md)
 - [Error](docs/Error.md)
 - [ErrorError](docs/ErrorError.md)
 - [ErrorErrorLink](docs/ErrorErrorLink.md)


## Documentation for Authorization

Authentication schemes defined for the API:
### devicesSecurity

- **Type**: HTTP basic authentication


## Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issues.

## Author



