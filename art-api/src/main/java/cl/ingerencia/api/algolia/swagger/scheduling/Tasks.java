package cl.ingerencia.api.algolia.swagger.scheduling;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import cl.ingerencia.api.algolia.db.model.Articulo;
import cl.ingerencia.api.algolia.db.service.ArtService;
import cl.ingerencia.client.algolia.swagger.codegen.api.ArticulosApi;
import cl.ingerencia.client.algolia.swagger.codegen.model.Articulos;
import cl.ingerencia.client.algolia.swagger.codegen.model.Hit;

@Component
public class Tasks {

    private static final Logger logger = LoggerFactory.getLogger(Tasks.class);
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
    @Autowired
    private ArtService service;

    @Scheduled(fixedDelay = 60000)
    public void scheduleTaskWithFixedDelay() throws InterruptedException {
        logger.info("Fixed Delay Task: Start Time - {}", formatter.format(LocalDateTime.now()));

        ArticulosApi api = new ArticulosApi();
        long i = 0;
        Articulos articulos = null;
        String regPorPag = "100";
        Boolean e = false;
        do{
	        articulos = api.articulos("nodejs", String.valueOf(i), regPorPag);i++;
	        e=i<articulos.getNbPages();
	        logger.info(articulos.getHits().size()+"");
	        for(Hit hit : articulos.getHits()){
	        	if(service.exists(hit.getObjectID().toBigInteger())){
	        		//e=false;
	        		//break; //cuando se encuentra con algun registro repetido se asume que los siguientes ya fueron revisados
	        		logger.info("repetido "+hit.getObjectID());
	        	}else{
	        		
	    	        logger.info(hit.getAuthor());
	    	        logger.info(hit.getObjectID()+"");
	    	        
		        	Articulo articulo = new Articulo();
		        	articulo.setId(hit.getObjectID().toBigInteger());
			        service.save(articulo);
	        	}
	        }
	        //una espera de 5 segundos entre llamados
	        TimeUnit.SECONDS.sleep(5);
	        
        }while(e);

        logger.info("Fixed Delay Task: End Time - {}", formatter.format(LocalDateTime.now()));
    }
}
