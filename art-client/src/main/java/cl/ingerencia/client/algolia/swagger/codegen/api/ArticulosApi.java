package cl.ingerencia.client.algolia.swagger.codegen.api;

import cl.ingerencia.client.algolia.swagger.ApiClient;

import cl.ingerencia.client.algolia.swagger.codegen.model.Articulos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;


@Component("cl.ingerencia.client.algolia.swagger.codegen.api.ArticulosApi")
public class ArticulosApi {
    private ApiClient apiClient;

    public ArticulosApi() {
        this(new ApiClient());
    }

    @Autowired
    public ArticulosApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Lista de articulos a procesar
     * 
     * <p><b>200</b> - Articulos
     * @param query The query parameter
     * @param page The page parameter
     * @param hitsPerPage The hitsPerPage parameter
     * @return Articulos
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Articulos articulos(String query, String page, String hitsPerPage) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'query' is set
        if (query == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'query' when calling articulos");
        }
        
        String path = UriComponentsBuilder.fromPath("/search_by_date").build().toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "query", query));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "page", page));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "hitsPerPage", hitsPerPage));

        final String[] accepts = { 
            "application/json"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<Articulos> returnType = new ParameterizedTypeReference<Articulos>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
}
