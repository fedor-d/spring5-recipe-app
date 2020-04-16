package pw.springdev.services;

import java.util.Set;

import org.springframework.stereotype.Service;
import pw.springdev.commands.RecipeCommand;
import pw.springdev.domain.Recipe;

/**
 * Created by FedorD on 2020-04-04
 */
@Service
public interface RecipeService {

    Set<Recipe> getRecipes();

    Recipe findById(Long id);

    RecipeCommand saveRecipeCommand(RecipeCommand command);

    RecipeCommand findCommandById(Long id);

    void deleteById(Long idToDelete);
}
