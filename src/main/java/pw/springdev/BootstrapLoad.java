package pw.springdev;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pw.springdev.domain.Category;
import pw.springdev.domain.Difficulty;
import pw.springdev.domain.Ingredient;
import pw.springdev.domain.Notes;
import pw.springdev.domain.Recipe;
import pw.springdev.domain.UnitOfMeasure;
import pw.springdev.repositories.CategoryRepository;
import pw.springdev.repositories.RecipeRepository;
import pw.springdev.repositories.UnitOfMeasureRepository;

/**
 * Created by FedorD on 2020-04-01
 */
@Component
public class BootstrapLoad implements CommandLineRunner {

    CategoryRepository categoryRepository;
    RecipeRepository recipeRepository;
    UnitOfMeasureRepository unitOfMeasureRepository;

    public BootstrapLoad(CategoryRepository categoryRepository, RecipeRepository recipeRepository,
        UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.recipeRepository = recipeRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Recipe perfectGuacamole = new Recipe();
        Recipe spicyGrilledChickenTacos = new Recipe();

        UnitOfMeasure pieceUOM = new UnitOfMeasure();
        pieceUOM.setDescription("Piece");
        var savedPieceUOM = unitOfMeasureRepository.save(pieceUOM);

        perfectGuacamole.setCategories(Set.of(categoryRepository.findByDescription("Mexican").get()));
        perfectGuacamole.setCookTime(10);
        perfectGuacamole.setDescription(
            "The best guacamole keeps it simple: just ripe avocados, salt, a squeeze of lime, onions, chiles, "
                + "cilantro, and some chopped tomato. Serve it as a dip at your next party or spoon it on top of "
                + "tacos for an easy dinner upgrade.");
        perfectGuacamole.setDifficulty(Difficulty.EASY);
        perfectGuacamole.setDirections("direction");
        Ingredient ing1 = new Ingredient();
        ing1.setAmount(new BigDecimal(2));
        ing1.setDescription("2 ripe avocado");
        ing1.setRecipe(perfectGuacamole);
        ing1.setUom(savedPieceUOM);

        Ingredient ing2 = new Ingredient();
        ing2.setAmount(new BigDecimal("0.25"));
        ing2.setDescription("1/4 teaspoon of salt, more to taste");
        ing2.setRecipe(perfectGuacamole);
        ing2.setUom(unitOfMeasureRepository.findByDescription("Teaspoon").get());

        Ingredient ing3 = new Ingredient();
        ing3.setAmount(new BigDecimal(1));
        ing3.setDescription("1 tablespoon fresh lime juice or lemon juice\n");
        ing3.setRecipe(perfectGuacamole);
        ing3.setUom(unitOfMeasureRepository.findByDescription("Tablespoon").get());

        Ingredient ing4 = new Ingredient();
        ing4.setAmount(new BigDecimal(2));
        ing4.setDescription("2 tablespoons to 1/4 cup of minced red onion or thinly sliced green onion\n");
        ing4.setRecipe(perfectGuacamole);
        ing4.setUom(unitOfMeasureRepository.findByDescription("Tablespoon").get());

        Ingredient ing5 = new Ingredient();
        ing5.setAmount(new BigDecimal("1.5"));
        ing5.setDescription("1-2 serrano chiles, stems and seeds removed, minced\n");
        ing5.setRecipe(perfectGuacamole);
        ing5.setUom(unitOfMeasureRepository.findByDescription("Piece").get());

        Ingredient ing6 = new Ingredient();
        ing6.setAmount(new BigDecimal(2));
        ing6.setDescription("2 tablespoons cilantro (leaves and tender stems), finely chopped\n");
        ing6.setRecipe(perfectGuacamole);
        ing6.setUom(unitOfMeasureRepository.findByDescription("Tablespoon").get());

        UnitOfMeasure dash = new UnitOfMeasure();
        dash.setDescription("Dash");
        UnitOfMeasure savedDash = unitOfMeasureRepository.save(dash);

        Ingredient ing7 = new Ingredient();
        ing7.setAmount(new BigDecimal(1));
        ing7.setDescription("A dash of freshly grated black pepper\n");
        ing7.setRecipe(perfectGuacamole);
        ing7.setUom(savedDash);

        Ingredient ing8 = new Ingredient();
        ing8.setAmount(new BigDecimal("0.5"));
        ing8.setDescription("1/2 ripe tomato, seeds and pulp removed, chopped\n");
        ing8.setRecipe(perfectGuacamole);
        ing8.setUom(unitOfMeasureRepository.findByDescription("Piece").get());

        Ingredient ing9 = new Ingredient();
        ing9.setAmount(new BigDecimal(1));
        ing9.setDescription("Red radishes or jicama, to garnish\n");
        ing9.setRecipe(perfectGuacamole);
        ing9.setUom(unitOfMeasureRepository.findByDescription("Piece").get());

        Ingredient ing10 = new Ingredient();
        ing10.setAmount(new BigDecimal(1));
        ing10.setDescription("Tortilla chips, to serve\n");
        ing10.setRecipe(perfectGuacamole);
        ing10.setUom(unitOfMeasureRepository.findByDescription("Pack").get());

        Set<Ingredient> ingredients1 = Set.of(ing1, ing2, ing3, ing4, ing5, ing6, ing7, ing8, ing9, ing10);

        perfectGuacamole.setIngredients(ingredients1);

        Notes perfectGuacamoleNotes = new Notes();
        perfectGuacamoleNotes.setRecipe(perfectGuacamole);
        perfectGuacamoleNotes.setRecipeNotes(
            "1 Cut the avocado, remove flesh: Cut the avocados in half. Remove the pit. "
                + "Score the inside of the avocado with a blunt knife and scoop out the flesh with a spoon. (See How "
                + "to "
                + "Cut and Peel an Avocado.) Place in a bowl.\n"
                + "\n"
                + "\n"
                + "\n"
                + "2 Mash with a fork: Using a fork, roughly mash the avocado. (Don't overdo it! The guacamole should"
                + " be "
                + "a little chunky.)\n"
                + "\n"
                + "\n"
                + "\n"
                + "3 Add salt, lime juice, and the rest: Sprinkle with salt and lime (or lemon) juice. The acid in the "
                + "lime juice will provide some balance to the richness of the avocado and will help delay the "
                + "avocados "
                + "from turning brown.\n"
                + "\n"
                + "Add the chopped onion, cilantro, black pepper, and chiles. Chili peppers vary individually in their "
                + "hotness. So, start with a half of one chili pepper and add to the guacamole to your desired degree"
                + " of "
                + "hotness.\n"
                + "\n"
                + "Remember that much of this is done to taste because of the variability in the fresh ingredients. "
                + "Start"
                + " with this recipe and adjust to your taste.\n"
                + "\n"
                + "Chilling tomatoes hurts their flavor, so if you want to add chopped tomato to your guacamole, add "
                + "it "
                + "just before serving.\n"
                + "\n"
                + "4 Serve: Serve immediately, or if making a few hours ahead, place plastic wrap on the surface of "
                + "the "
                + "guacamole and press down to cover it and to prevent air reaching it. (The oxygen in the air causes "
                + "oxidation which will turn the guacamole brown.) Refrigerate until ready to serve.");
        perfectGuacamole.setNotes(perfectGuacamoleNotes);
        perfectGuacamole.setPrepTime(10);
        perfectGuacamole.setServings(5);
        perfectGuacamole.setSource("www.simplyrecipes.com");
        perfectGuacamole.setUrl("https://www.simplyrecipes.com/recipes/perfect_guacamole/");

        recipeRepository.save(perfectGuacamole);

        spicyGrilledChickenTacos.setCategories(Set.of(categoryRepository.findByDescription("Interesting").get()));
        spicyGrilledChickenTacos.setCookTime(15);
        spicyGrilledChickenTacos.setDescription(
            "Spicy grilled chicken tacos! Quick marinade, then grill. Ready in about 30 minutes. Great for a quick weeknight dinner, backyard cookouts, and tailgate parties.");
        spicyGrilledChickenTacos.setDifficulty(Difficulty.EASY);
        spicyGrilledChickenTacos.setDirections("direction");

        Ingredient tacosIng1 = new Ingredient();
        tacosIng1.setAmount(new BigDecimal(2));
        tacosIng1.setDescription("2 tablespoons ancho chili powder");
        tacosIng1.setRecipe(spicyGrilledChickenTacos);
        tacosIng1.setUom(unitOfMeasureRepository.findByDescription("Tablespoon").get());

        Ingredient tacosIng2 = new Ingredient();
        tacosIng2.setAmount(new BigDecimal(1));
        tacosIng2.setDescription("1 teaspoon dried oregano\n");
        tacosIng2.setRecipe(spicyGrilledChickenTacos);
        tacosIng2.setUom(unitOfMeasureRepository.findByDescription("Teaspoon").get());

        Ingredient tacosIng3 = new Ingredient();
        tacosIng3.setAmount(new BigDecimal(1));
        tacosIng3.setDescription("1 teaspoon dried cumin\n");
        tacosIng3.setRecipe(spicyGrilledChickenTacos);
        tacosIng3.setUom(unitOfMeasureRepository.findByDescription("Teaspoon").get());

        Ingredient tacosIng4 = new Ingredient();
        tacosIng4.setAmount(new BigDecimal(1));
        tacosIng4.setDescription("1 teaspoon sugar\n");
        tacosIng4.setRecipe(spicyGrilledChickenTacos);
        tacosIng4.setUom(unitOfMeasureRepository.findByDescription("Teaspoon").get());

        Ingredient tacosIng5 = new Ingredient();
        tacosIng5.setAmount(new BigDecimal("0.5"));
        tacosIng5.setDescription("1/2 teaspoon salt\n");
        tacosIng5.setRecipe(spicyGrilledChickenTacos);
        tacosIng5.setUom(unitOfMeasureRepository.findByDescription("Teaspoon").get());

        Ingredient tacosIng6 = new Ingredient();
        tacosIng6.setAmount(new BigDecimal(1));
        tacosIng6.setDescription("1 clove garlic, finely chopped\n");
        tacosIng6.setRecipe(spicyGrilledChickenTacos);
        tacosIng6.setUom(unitOfMeasureRepository.findByDescription("Piece").get());

        Ingredient tacosIng7 = new Ingredient();
        tacosIng7.setAmount(new BigDecimal(1));
        tacosIng7.setDescription("1 tablespoon finely grated orange zest\n");
        tacosIng7.setRecipe(spicyGrilledChickenTacos);
        tacosIng7.setUom(unitOfMeasureRepository.findByDescription("Tablespoon").get());

        Ingredient tacosIng8 = new Ingredient();
        tacosIng8.setAmount(new BigDecimal("3"));
        tacosIng8.setDescription("3 tablespoons fresh-squeezed orange juice\n");
        tacosIng8.setRecipe(spicyGrilledChickenTacos);
        tacosIng8.setUom(unitOfMeasureRepository.findByDescription("Tablespoon").get());

        Ingredient tacosIng9 = new Ingredient();
        tacosIng9.setAmount(new BigDecimal(2));
        tacosIng9.setDescription("2 tablespoons olive oil\n");
        tacosIng9.setRecipe(spicyGrilledChickenTacos);
        tacosIng9.setUom(unitOfMeasureRepository.findByDescription("Tablespoon").get());

        Ingredient tacosIng10 = new Ingredient();
        tacosIng10.setAmount(new BigDecimal(5));
        tacosIng10.setDescription("4 to 6 skinless, boneless chicken thighs (1 1/4 pounds)\n");
        tacosIng10.setRecipe(spicyGrilledChickenTacos);
        tacosIng10.setUom(unitOfMeasureRepository.findByDescription("Piece").get());

        Set<Ingredient> tacosIngredients1 = Set.of(tacosIng1, tacosIng2, tacosIng3, tacosIng4, tacosIng5, tacosIng6, tacosIng7, tacosIng8, tacosIng9, tacosIng10);

        spicyGrilledChickenTacos.setIngredients(tacosIngredients1);

        Notes spicyGrilledChickenTacosNotes = new Notes();
        spicyGrilledChickenTacosNotes.setRecipe(spicyGrilledChickenTacos);
        spicyGrilledChickenTacosNotes.setRecipeNotes(
            "1 Prepare a gas or charcoal grill for medium-high, direct heat.\n"
                + "\n"
                + "2 Make the marinade and coat the chicken: In a large bowl, stir together the chili powder, "
                + "oregano, cumin, sugar, salt, garlic and orange zest. Stir in the orange juice and olive oil to "
                + "make a loose paste. Add the chicken to the bowl and toss to coat all over.\n"
                + "\n"
                + "Set aside to marinate while the grill heats and you prepare the rest of the toppings.\n"
                + "\n"
                + "Spicy Grilled Chicken Tacos\n"
                + "\n"
                + "3 Grill the chicken: Grill the chicken for 3 to 4 minutes per side, or until a thermometer "
                + "inserted into the thickest part of the meat registers 165F. Transfer to a plate and rest for 5 "
                + "minutes.\n"
                + "\n"
                + "4 Warm the tortillas: Place each tortilla on the grill or on a hot, dry skillet over medium-high "
                + "heat. As soon as you see pockets of the air start to puff up in the tortilla, turn it with tongs "
                + "and heat for a few seconds on the other side.\n"
                + "\n"
                + "Wrap warmed tortillas in a tea towel to keep them warm until serving.\n"
                + "\n"
                + "5 Assemble the tacos: Slice the chicken into strips. On each tortilla, place a small handful of "
                + "arugula. Top with chicken slices, sliced avocado, radishes, tomatoes, and onion slices. Drizzle "
                + "with the thinned sour cream. Serve with lime wedges.");
        spicyGrilledChickenTacos.setNotes(spicyGrilledChickenTacosNotes);
        spicyGrilledChickenTacos.setPrepTime(20);
        spicyGrilledChickenTacos.setServings(5);
        spicyGrilledChickenTacos.setSource("www.simplyrecipes.com");
        spicyGrilledChickenTacos.setUrl("https://www.simplyrecipes.com/recipes/spicy_grilled_chicken_tacos/");

        recipeRepository.save(spicyGrilledChickenTacos);

    }
}
