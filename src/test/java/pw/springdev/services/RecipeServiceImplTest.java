package pw.springdev.services;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import pw.springdev.domain.Recipe;
import pw.springdev.repositories.RecipeRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class RecipeServiceImplTest {

    RecipeServiceImpl recipeService;

    @Mock
    RecipeRepository recipeRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        recipeService = new RecipeServiceImpl(recipeRepository);
    }

    @Test
    void givenZeroRecipes_whenGetRecipes_thenRecipesSizeIsZero() {

        Set<Recipe> recipes = recipeService.getRecipes();
        assertEquals(0, recipes.size());
    }

    @Test
    void givenOneRecipe_whenGetRecipes_thenRecipesSizeIsOne() {
        Recipe recipe = new Recipe();
        Set<Recipe> recipesData = new HashSet<>();
        recipesData.add(recipe);

        when(recipeRepository.findAll()).thenReturn(recipesData);

        Set<Recipe> recipes = (Set<Recipe>)recipeRepository.findAll();


        assertEquals(1, recipes.size());
        verify(recipeRepository, times(1)).findAll();
    }
}