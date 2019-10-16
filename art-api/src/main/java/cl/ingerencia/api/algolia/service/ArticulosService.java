package cl.ingerencia.api.algolia.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import cl.ingerencia.api.algolia.db.model.Articulo;
import cl.ingerencia.api.algolia.db.repository.ArtRepository;
import cl.ingerencia.api.algolia.db.repository.ArtRepositoryPag;
import cl.ingerencia.api.algolia.swagger.codegen.model.Paginacion;

@Service
public class ArticulosService {
	
	@Autowired
    private ArtRepositoryPag artRepositoryPag;
	
	public Paginacion getArticulos(int page){
		Pageable paging = new PageRequest(page, 20, Direction.DESC, "id");
		Page<Articulo> pagedResult = artRepositoryPag.findAll(paging);
		Paginacion p = new Paginacion();
		List<cl.ingerencia.api.algolia.swagger.codegen.model.Articulo> l = new ArrayList<cl.ingerencia.api.algolia.swagger.codegen.model.Articulo>();
		for(Articulo a : pagedResult.getContent()){
			cl.ingerencia.api.algolia.swagger.codegen.model.Articulo aa = new cl.ingerencia.api.algolia.swagger.codegen.model.Articulo();
			aa.setObjectID(BigDecimal.valueOf(a.getId().longValueExact()));//<-- cambiar bigdecimal por biginteger o long
			l.add(aa);
		}
		p.setArticulos(l);
		p.setQuery("test");
		return p;
	}
	
}
