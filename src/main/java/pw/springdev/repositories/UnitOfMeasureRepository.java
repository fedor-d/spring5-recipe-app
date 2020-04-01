package pw.springdev.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import pw.springdev.domain.UnitOfMeasure;

/**
 * Created by FedorD on 2020-04-01
 */
public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {
    Optional<UnitOfMeasure> findByDescription(String description);
}
