package se.ecutb.loffe.recipe_db.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.ecutb.loffe.recipe_db.entity.RecipeIngredient;

@Repository
public interface RecipeIngredientRepo extends JpaRepository<RecipeIngredient, String> {

}
