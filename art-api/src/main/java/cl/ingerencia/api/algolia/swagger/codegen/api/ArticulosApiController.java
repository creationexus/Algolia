package cl.ingerencia.api.algolia.swagger.codegen.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import cl.ingerencia.api.algolia.service.ArticulosService;
import cl.ingerencia.api.algolia.swagger.codegen.model.Paginacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Controller
public class ArticulosApiController implements ArticulosApi {

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;
    
    @Autowired
    private ArticulosService articulosService;

    @org.springframework.beans.factory.annotation.Autowired
    public ArticulosApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    @Override
    public Optional<ObjectMapper> getObjectMapper() {
        return Optional.ofNullable(objectMapper);
    }

    @Override
    public Optional<HttpServletRequest> getRequest() {
        return Optional.ofNullable(request);
    }
    
    @Override
    public ResponseEntity<Paginacion> articulos(String query, String page) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                    Paginacion detalle = articulosService.getArticulos(Integer.parseInt(page));
                    ResponseEntity<Paginacion> respuesta = new ResponseEntity<>(detalle, HttpStatus.OK);
                    return respuesta;
                } catch (Exception e) {
                    log.error("Couldn't serialize response for content type application/xml", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default DefaultApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

}
