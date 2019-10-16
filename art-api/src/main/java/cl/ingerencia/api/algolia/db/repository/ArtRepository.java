package cl.ingerencia.api.algolia.db.repository;

import java.math.BigInteger;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import cl.ingerencia.api.algolia.db.model.Articulo;

@Repository
public interface ArtRepository extends CrudRepository<Articulo, BigInteger> {}
