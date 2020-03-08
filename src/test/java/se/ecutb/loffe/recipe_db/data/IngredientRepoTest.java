package se.ecutb.loffe.recipe_db.data;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import se.ecutb.loffe.recipe_db.entity.Ingredient;

@DataJpaTest
public class IngredientRepoTest {

    @Autowired
    private IngredientRepo testObject;

    Ingredient ingredientTomato = new Ingredient("Tomato");
    Ingredient ingredientTomatoSauce = new Ingredient("Tomato sauce");

    @BeforeEach
    public void setup() {
        testObject.save(ingredientTomato);
        testObject.save(ingredientTomatoSauce);
    }

    @Test
    public void given_name_find_one_ingredient() {
        String searchFor = "tomato";

        Assertions.assertNotNull(testObject.findByIngredientNameIgnoreCase(searchFor));
        Assertions.assertEquals("tomato", testObject.findByIngredientNameIgnoreCase(searchFor)
                .get()
                .getIngredientName()
                .toLowerCase());
    }

    @Test
    public void given_string_find_2_ingredients() {
        String searchFor = "tomato";
        int expectedSize = 2;

        Assertions.assertNotNull(testObject.findByIngredientNameContainsIgnoreCase(searchFor));
        Assertions.assertEquals(expectedSize, testObject.findByIngredientNameContainsIgnoreCase(searchFor).size());
    }

}
