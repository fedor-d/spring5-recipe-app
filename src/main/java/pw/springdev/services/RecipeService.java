package pw.springdev.services;

import org.springframework.stereotype.Service;
import pw.springdev.commands.RecipeCommand;
import pw.springdev.domain.Recipe;
import pw.springdev.repositories.RecipeRepository;

import java.util.List;
import java.util.Set;

/**
 * Created by FedorD on 2020-04-04
 */
@Service
public interface RecipeService {
    Set<Recipe> getRecipes();
    Recipe findById(Long id);
    RecipeCommand saveRecipeCommand(RecipeCommand command);
}
