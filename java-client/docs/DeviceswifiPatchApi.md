# DeviceswifiPatchApi

All URIs are relative to *https://apistage.net.com.br/sdp*

Method | HTTP request | Description
------------- | ------------- | -------------
[**deviceswifiPatch**](DeviceswifiPatchApi.md#deviceswifiPatch) | **PATCH** /deviceswifi | Alterar a senha wifi do cliente NET.


<a name="deviceswifiPatch"></a>
# **deviceswifiPatch**
> DeviceswifiResponsePATCH deviceswifiPatch(xApiVersion, xMetadata, body)

Alterar a senha wifi do cliente NET.

O recurso /deviceswifi PATCH tem como objetivo prover para o cliente a  funcionalidade de alterar a senha ou ssid de um dispositivo Wi-Fi Net nos canais de autoatendimento Digital, Site Net Combo e Mobile. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DeviceswifiPatchApi;


DeviceswifiPatchApi apiInstance = new DeviceswifiPatchApi();
String xApiVersion = "xApiVersion_example"; // String | Header com a definição da versão da API a ser consumida
String xMetadata = "xMetadata_example"; // String | Header que define a necessidade do campo metada no response. Permitido \"true\" ou \"false\".
Body body = new Body(); // Body | Objeto com as informações necessárias para alterar a senha ou SSID do equipamento
try {
    DeviceswifiResponsePATCH result = apiInstance.deviceswifiPatch(xApiVersion, xMetadata, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DeviceswifiPatchApi#deviceswifiPatch");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **xApiVersion** | **String**| Header com a definição da versão da API a ser consumida | [optional]
 **xMetadata** | **String**| Header que define a necessidade do campo metada no response. Permitido \&quot;true\&quot; ou \&quot;false\&quot;. | [optional]
 **body** | [**Body**](Body.md)| Objeto com as informações necessárias para alterar a senha ou SSID do equipamento | [optional]

### Return type

[**DeviceswifiResponsePATCH**](DeviceswifiResponsePATCH.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

