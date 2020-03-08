package se.ecutb.loffe.recipe_db.data;

import org.springframework.data.jpa.repository.JpaRepository;
import se.ecutb.loffe.recipe_db.entity.Ingredient;

import java.util.List;
import java.util.Optional;


public interface IngredientRepo extends JpaRepository<Ingredient, Integer> {

    Optional<Ingredient> findByIngredientNameIgnoreCase(String ingredientName);
    List<Ingredient> findByIngredientNameContainsIgnoreCase(String ingredientName);
}
