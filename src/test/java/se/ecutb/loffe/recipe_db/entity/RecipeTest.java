package se.ecutb.loffe.recipe_db.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class RecipeTest {

    private Recipe testObject;
    private RecipeCategory testCategory;
    private Ingredient testIngredient;
    private RecipeIngredient testRecipeIngredient;

    @BeforeEach
    public void setup() {
        testObject = new Recipe("Test recipe");
        testCategory = new RecipeCategory("Test category");
        testIngredient = new Ingredient("Test ingredient");
        testRecipeIngredient = new RecipeIngredient(testIngredient);
    }

    @Test
    public void add_1_category_get_size_1() {
        Assertions.assertEquals(0, testObject.getCategories().size());
        testObject.addCategory(testCategory);
        Assertions.assertEquals(1, testObject.getCategories().size());
    }

    @Test
    public void add_1_category_then_remove_1_category_get_size_0() {
        Assertions.assertEquals(0, testObject.getCategories().size());
        testObject.addCategory(testCategory);
        Assertions.assertEquals(1, testObject.getCategories().size());
        testObject.removeCategory(testCategory);
        Assertions.assertEquals(0, testObject.getCategories().size());
    }

    @Test
    public void add_null_category_get_0_size() {
        Assertions.assertEquals(0, testObject.getCategories().size());
        Assertions.assertFalse(testObject.addCategory(null));
        Assertions.assertEquals(0, testObject.getCategories().size());
    }

    @Test
    public void remove_category_that_doesnt_exists_dont_alter_recipe() {
        Assertions.assertEquals(0, testObject.getCategories().size());
        Recipe originalRecipe = testObject;
        testObject.removeCategory(testCategory);
        Assertions.assertEquals(0, testObject.getCategories().size());
        Assertions.assertEquals(originalRecipe, testObject);
    }

    @Test
    public void add_1_ingredient_get_size_1() {
        Assertions.assertEquals(0, testObject.getRecipeIngredients().size());
        testObject.addRecipeIngredient(testRecipeIngredient);
        Assertions.assertEquals(1, testObject.getRecipeIngredients().size());
    }

    @Test
    public void add_null_ingredient_get_0_size() {
        Assertions.assertEquals(0, testObject.getRecipeIngredients().size());
        Assertions.assertFalse(testObject.addRecipeIngredient(null));
        Assertions.assertEquals(0, testObject.getRecipeIngredients().size());
    }

    @Test
    public void add_1_ingredient_then_remove_1_ingredient_get_size_1() {
        Assertions.assertEquals(0, testObject.getRecipeIngredients().size());
        testObject.addRecipeIngredient(testRecipeIngredient);
        Assertions.assertEquals(1, testObject.getRecipeIngredients().size());
        testObject.removeRecipeIngredient(testRecipeIngredient);
        Assertions.assertEquals(0, testObject.getRecipeIngredients().size());
    }

    @Test
    public void remove_ingredient_that_doesnt_exists_dont_alter_recipe() {
        Assertions.assertEquals(0, testObject.getRecipeIngredients().size());
        Recipe originalRecipe = testObject;
        testObject.removeRecipeIngredient(testRecipeIngredient);
        Assertions.assertEquals(0, testObject.getRecipeIngredients().size());
        Assertions.assertEquals(originalRecipe, testObject);
    }
}
