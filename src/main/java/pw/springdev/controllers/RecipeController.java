package pw.springdev.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pw.springdev.services.RecipeService;

/**
 * Created by FedorD on 2020-04-15
 */
@Controller
public class RecipeController {

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    final RecipeService recipeService;

    @RequestMapping("/recipe/show/{id}")
    public String showById(@PathVariable String id, Model model) {

        model.addAttribute("recipe", recipeService.findById(Long.parseLong(id)));

        return "recipe/show";
    }


}
