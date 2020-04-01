package pw.springdev.controllers;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import pw.springdev.domain.Category;
import pw.springdev.domain.UnitOfMeasure;
import pw.springdev.repositories.CategoryRepository;
import pw.springdev.repositories.UnitOfMeasureRepository;

/**
 * Created by FedorD on 2020-03-25
 */
@Controller
public class IndexController {

    private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;

    public IndexController(CategoryRepository categoryRepository,
        UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @RequestMapping({"", "/","/index"})
    public String getIndexPage() {

        Optional<Category> categoryOptional = categoryRepository.findByDescription("Mexican");
        Optional<UnitOfMeasure> unitOfMeasureOptional = unitOfMeasureRepository.findByDescription("Cup");

        System.out.println("Category ID is: " + categoryOptional.get().getId());
        System.out.println("Unit of Measure ID is: " + unitOfMeasureOptional.get().getId());

        return "index";
    }

}
