package pw.springdev.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import pw.springdev.domain.Category;

/**
 * Created by FedorD on 2020-04-01
 */
public interface CategoryRepository extends CrudRepository<Category, Long> {

    Optional<Category> findByDescription(String description);
}
