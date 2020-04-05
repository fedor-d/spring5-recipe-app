package pw.springdev.services;

import org.springframework.stereotype.Service;
import pw.springdev.domain.Recipe;
import pw.springdev.repositories.RecipeRepository;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by FedorD on 2020-04-04
 */
@Service
public class RecipeServiceImpl implements RecipeService {
    private final RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Set<Recipe> getRecipes() {
        Set<Recipe> recipeSet = new HashSet<>();
        recipeRepository.findAll().iterator().forEachRemaining(recipeSet::add);
        return recipeSet;
    }
}
