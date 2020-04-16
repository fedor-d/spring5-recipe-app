package pw.springdev.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pw.springdev.commands.RecipeCommand;
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

    @RequestMapping("/recipe/{id}/show")
    public String showById(@PathVariable String id, Model model) {

        model.addAttribute("recipe", recipeService.findById(Long.parseLong(id)));

        return "recipe/show";
    }

    @RequestMapping("recipe/new")
    public String newRecipe(Model model) {

        model.addAttribute("recipe", new RecipeCommand());

        return "recipe/recipeform";
    }

    @RequestMapping("recipe/{id}/update")
    public String updateRecipe(@PathVariable String id, Model model) {

        model.addAttribute("recipe", recipeService.findCommandById(Long.valueOf(id)));

        return "recipe/recipeform";
    }

    //old way - @RequestMapping(name = "recipe", method = RequestMethod.POST)
    @PostMapping
    @RequestMapping("recipe")
    public String saveOrUpdate(@ModelAttribute RecipeCommand command) {
        RecipeCommand savedCommand = recipeService.saveRecipeCommand(command);

        return "redirect:/recipe/" + savedCommand.getId() + "/show";
    }
}
