# ArticulosApi

All URIs are relative to *https://hn.algolia.com/api/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**articulos**](ArticulosApi.md#articulos) | **GET** /search_by_date | Lista de articulos a procesar


<a name="articulos"></a>
# **articulos**
> Articulos articulos(query, page, hitsPerPage)

Lista de articulos a procesar

### Example
```java
// Import classes:
//import cl.ingerencia.client.algolia.swagger.ApiException;
//import cl.ingerencia.client.algolia.swagger.codegen.api.ArticulosApi;


ArticulosApi apiInstance = new ArticulosApi();
String query = "query_example"; // String | 
String page = "page_example"; // String | 
String hitsPerPage = "hitsPerPage_example"; // String | 
try {
    Articulos result = apiInstance.articulos(query, page, hitsPerPage);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ArticulosApi#articulos");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **query** | **String**|  |
 **page** | **String**|  | [optional]
 **hitsPerPage** | **String**|  | [optional]

### Return type

[**Articulos**](Articulos.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

