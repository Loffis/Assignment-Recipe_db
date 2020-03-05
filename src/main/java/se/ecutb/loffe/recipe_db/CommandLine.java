package se.ecutb.loffe.recipe_db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import se.ecutb.loffe.recipe_db.data.*;
import se.ecutb.loffe.recipe_db.entity.*;

import java.util.Arrays;

@Component
public class CommandLine implements CommandLineRunner {

    private IngredientRepo ingredientRepo;
    private RecipeRepo recipeRepo;
    private RecipeCategoryRepo recipeCategoryRepo;
    private RecipeIngredientRepo recipeIngredientRepo;
    private RecipeInstructionRepo recipeInstructionRepo;

    @Autowired
    public CommandLine(
            IngredientRepo ingredientRepo,
            RecipeRepo recipeRepo,
            RecipeCategoryRepo recipeCategoryRepo,
            RecipeIngredientRepo recipeIngredientRepo,
            RecipeInstructionRepo recipeInstructionRepo
            ) {
        this.ingredientRepo = ingredientRepo;
        this.recipeRepo = recipeRepo;
        this.recipeCategoryRepo = recipeCategoryRepo;
        this.recipeIngredientRepo = recipeIngredientRepo;
        this.recipeInstructionRepo = recipeInstructionRepo;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {

        Ingredient ingredient1 = new Ingredient("Potato");
        Ingredient ingredient2 = new Ingredient("Tomato");
        Ingredient ingredient3 = new Ingredient("Tomato sauce");

        RecipeInstruction recipeInstruction1 = new RecipeInstruction("Baka kaka.");
        RecipeInstruction recipeInstruction2 = new RecipeInstruction("Baka tårta.");
        RecipeInstruction recipeInstruction3 = new RecipeInstruction("Skär korv. Baka tårta.");

        RecipeCategory recipeCategory1 = new RecipeCategory("Frukost", null);
        RecipeCategory recipeCategory2 = new RecipeCategory("Gott", null);

        RecipeIngredient recipeIngredient1 = new RecipeIngredient(ingredient1, 1000, Measurement.KG, null);
        RecipeIngredient recipeIngredient2 = new RecipeIngredient(ingredient2, 1, Measurement.ST, null);
        RecipeIngredient recipeIngredient3 = new RecipeIngredient(ingredient3, 500, Measurement.ML, null);

        Recipe recipe1 = new Recipe("Banankaka", null, recipeInstruction1, null);
        Recipe recipe2 = new Recipe("Banantårta", null, recipeInstruction2, null);
        Recipe recipe3 = new Recipe("Korvtårta", null, recipeInstruction3, null);

        System.out.println(recipe1.addCategory(recipeCategory1));
        System.out.println(recipe1.addCategory(recipeCategory2));

        recipe1.addRecipeIngredient(recipeIngredient1);
        recipe1.addRecipeIngredient(recipeIngredient2);
        recipe1.addRecipeIngredient(recipeIngredient3);

        recipeRepo.save(recipe1);
        recipeRepo.save(recipe2);
        recipeRepo.save(recipe3);

        //System.out.println(ingredientRepo.findByIngredientNameIgnoreCase("tomato"));
        //System.out.println(ingredientRepo.findByIngredientNameContainsIgnoreCase("ato"));

        //System.out.println(recipeRepo.findByRecipeNameContainsIgnoreCase("banan"));
        //System.out.println(recipeRepo.findByRecipeIngredientsIngredientIngredientNameContainsIgnoreCase("tomato"));

        //System.out.println(recipeRepo.findByCategoriesCategoryContainsIgnoreCase("go"));
        System.out.println(recipeRepo.findRecipesByCategoriesWithQuery(Arrays.asList("frukost", "gott")));

    }
}
