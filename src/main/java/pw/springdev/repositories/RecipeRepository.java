package pw.springdev.repositories;

import org.springframework.data.repository.CrudRepository;
import pw.springdev.domain.Recipe;

/**
 * Created by FedorD on 2020-04-01
 */
public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
