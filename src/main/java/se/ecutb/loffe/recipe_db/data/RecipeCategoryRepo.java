package se.ecutb.loffe.recipe_db.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.ecutb.loffe.recipe_db.entity.RecipeCategory;

@Repository
public interface RecipeCategoryRepo extends JpaRepository<RecipeCategory, Integer> {
}
