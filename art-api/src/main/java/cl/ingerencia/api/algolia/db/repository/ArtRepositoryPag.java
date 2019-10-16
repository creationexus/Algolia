package cl.ingerencia.api.algolia.db.repository;

import java.math.BigInteger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import cl.ingerencia.api.algolia.db.model.Articulo;

public interface ArtRepositoryPag extends PagingAndSortingRepository<Articulo, BigInteger> {
    Page<Articulo> findAll(Pageable pageable);
}