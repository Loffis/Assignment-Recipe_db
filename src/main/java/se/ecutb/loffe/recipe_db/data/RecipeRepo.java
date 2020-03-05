package se.ecutb.loffe.recipe_db.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import se.ecutb.loffe.recipe_db.entity.Recipe;

import java.util.List;
import java.util.Set;

public interface RecipeRepo extends JpaRepository<Recipe, Integer> {

    List<Recipe> findByRecipeNameContainsIgnoreCase(String recipeName);

    Set<Recipe> findByRecipeIngredientsIngredientIngredientNameContainsIgnoreCase(String ingredientName);

    Set<Recipe> findByCategoriesCategoryContainsIgnoreCase(String recipeCategory);

    @Query("SELECT recipe FROM Recipe recipe JOIN FETCH recipe.categories recipeCategory WHERE" +
            " recipeCategory.category IN :categories")
    Set<Recipe> findRecipesByCategoriesWithQuery(@Param("categories")List<String> categories);

}
