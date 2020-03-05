package se.ecutb.loffe.recipe_db.data;

import org.springframework.data.jpa.repository.JpaRepository;
import se.ecutb.loffe.recipe_db.entity.RecipeCategory;

public interface RecipeCategoryRepo extends JpaRepository<RecipeCategory, Integer> {
}
