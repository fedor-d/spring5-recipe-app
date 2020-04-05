package pw.springdev.controllers;

import java.util.Optional;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pw.springdev.domain.Category;
import pw.springdev.domain.UnitOfMeasure;
import pw.springdev.repositories.CategoryRepository;
import pw.springdev.repositories.UnitOfMeasureRepository;
import pw.springdev.services.RecipeService;

/**
 * Created by FedorD on 2020-03-25
 */
@Slf4j
@Controller
public class IndexController {

    private final RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(Model model) {
        log.debug("Getting Index page");

        model.addAttribute("recipes", recipeService.getRecipes());

        return "index";
    }

}
