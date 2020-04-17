package pw.springdev.services;

import pw.springdev.commands.IngredientCommand;

/**
 * Created by FedorD on 2020-04-16
 */
public interface IngredientService {
    IngredientCommand findByRecipeIdAndIngredientId(Long recipeId, Long ingredientId);

    IngredientCommand saveIngredientCommand(IngredientCommand command);
}
