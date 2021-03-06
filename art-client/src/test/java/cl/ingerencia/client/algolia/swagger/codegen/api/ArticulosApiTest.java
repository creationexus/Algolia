/*
 * API Articulos
 * Prueba para desafío de implementación
 *
 * OpenAPI spec version: 1.0.0
 * Contact: random@deltaquo.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package cl.ingerencia.client.algolia.swagger.codegen.api;

import cl.ingerencia.client.algolia.swagger.codegen.model.Articulos;
import org.junit.Test;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for ArticulosApi
 */
@Ignore
public class ArticulosApiTest {

    private final ArticulosApi api = new ArticulosApi();

    
    /**
     * Lista de articulos a procesar
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void articulosTest() {
        String query = null;
        String page = null;
        String hitsPerPage = null;
        Articulos response = api.articulos(query, page, hitsPerPage);

        // TODO: test validations
    }
    
}
