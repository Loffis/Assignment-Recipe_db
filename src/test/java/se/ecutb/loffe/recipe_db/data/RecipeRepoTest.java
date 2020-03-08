package se.ecutb.loffe.recipe_db.data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import se.ecutb.loffe.recipe_db.entity.*;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class RecipeRepoTest {

    @Autowired
    private RecipeRepo testObject;

    private RecipeCategory recipeCategory1;
    private RecipeCategory recipeCategory2;
    private RecipeIngredient recipeIngredient1;
    private RecipeIngredient recipeIngredient2;
    private RecipeInstruction recipeInstruction;
    private Recipe testRecipe1;
    private Recipe testRecipe2;

    @BeforeEach
    public void setup() {
        testRecipe1 = new Recipe("Tomato salad");
        testRecipe2 = new Recipe("Greek salad");
        recipeIngredient1 = new RecipeIngredient(new Ingredient("Tomato"));
        recipeIngredient2 = new RecipeIngredient(new Ingredient("Cheese"));
        recipeInstruction = new RecipeInstruction("Do this. Then that.");
        recipeCategory1 = new RecipeCategory("Salad");
        recipeCategory2 = new RecipeCategory("Mediterranean");

        testRecipe1.addRecipeIngredient(recipeIngredient1);
        testRecipe1.addCategory(recipeCategory1);
        testRecipe1.setInstruction(recipeInstruction);

        testRecipe2.addRecipeIngredient(recipeIngredient2);
        testRecipe2.addCategory(recipeCategory1);
        testRecipe2.addCategory(recipeCategory2);
        testRecipe2.setInstruction(recipeInstruction);

        testObject.save(testRecipe1);
        testObject.save(testRecipe2);
    }

    @Test
    public void find_recipe_by_name_get_list_size_2() {
        String searchWord = "salad";
        int expectedSize = 2;

        assertEquals(expectedSize, testObject.findByRecipeNameContainsIgnoreCase(searchWord).size());
    }

    @Test
    public void find_recipe_by_ingredient_get_list_size_1() {
        String searchWord = "tomat";
        int expectedSize = 1;

        assertEquals(expectedSize, testObject
                .findByRecipeIngredientsIngredientIngredientNameContainsIgnoreCase(searchWord).size());
    }

    @Test
    public void find_recipe_by_category_get_list_size_1() {
        String searchWord = "medi";
        int expectedSize = 1;

        assertEquals(expectedSize, testObject.findByCategoriesCategoryContainsIgnoreCase(searchWord).size());
    }

    @Test
    public void find_recipe_by_category_list_get_list_size_2() {
        List<String> categoriesToFind = Arrays.asList("Mediterranean", "Salad");
        int expectedSize = 2;

        assertEquals(expectedSize, testObject.findRecipesByCategoriesWithQuery(categoriesToFind).size());
    }


}
