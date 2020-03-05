package se.ecutb.loffe.recipe_db.data;

import org.springframework.data.jpa.repository.JpaRepository;
import se.ecutb.loffe.recipe_db.entity.RecipeIngredient;

public interface RecipeIngredientRepo extends JpaRepository<RecipeIngredient, String> {

}
