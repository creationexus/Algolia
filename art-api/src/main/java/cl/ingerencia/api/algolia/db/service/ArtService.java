package cl.ingerencia.api.algolia.db.service;

import java.math.BigInteger;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cl.ingerencia.api.algolia.db.model.Articulo;
import cl.ingerencia.api.algolia.db.repository.ArtRepository;

@Service
@Transactional
public class ArtService {
	@Autowired
    private ArtRepository artRepository;
	
	public void save(Articulo a){
		artRepository.save(a);
	}
	
	public Boolean exists(BigInteger id){
		return artRepository.exists(id);
	}
}
