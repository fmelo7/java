# DeviceswifiGetApi

All URIs are relative to *https://apistage.net.com.br/sdp*

Method | HTTP request | Description
------------- | ------------- | -------------
[**deviceswifiGet**](DeviceswifiGetApi.md#deviceswifiGet) | **GET** /deviceswifi | Recuperar a senha wifi do cliente NET.


<a name="deviceswifiGet"></a>
# **deviceswifiGet**
> DeviceswifiResponseGET deviceswifiGet(filter, xApiVersion, xMetadata)

Recuperar a senha wifi do cliente NET.

O recurso /deviceswifi GET tem como objetivo prover para o cliente a funcionalidade de recuperar a senha/ssid de um dispositivo Wi-Fi Net nos canais de autoatendimento Digital, Site Net Combo e Mobile. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DeviceswifiGetApi;


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
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **filter** | **String**| Filtros para deviceswifi. Formato para envio dos filtros \&quot;filter&#x3D;\&quot;legalNatureCode::VALOR|customerAccountId::VALOR\&quot;.  Campos obrigatorios &gt;   Os campos legalNatureCode (Código operadora) e customerAccountId    (Contrato do cliente) são ambos obrigatórios.  |
 **xApiVersion** | **String**| Header com a definição da versão da API a ser consumida | [optional]
 **xMetadata** | **String**| Header que define a necessidade do campo metada no response. Permitido \&quot;true\&quot; ou \&quot;false\&quot;. | [optional]

### Return type

[**DeviceswifiResponseGET**](DeviceswifiResponseGET.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

