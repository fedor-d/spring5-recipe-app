package pw.springdev.repositories;

import org.springframework.data.repository.CrudRepository;
import pw.springdev.domain.Category;

/**
 * Created by FedorD on 2020-04-01
 */
public interface CategoryRepository extends CrudRepository<Category, Long> {
}
