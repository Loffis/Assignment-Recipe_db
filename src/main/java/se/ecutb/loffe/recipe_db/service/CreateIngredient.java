package se.ecutb.loffe.recipe_db.service;

import org.springframework.transaction.annotation.Transactional;
import se.ecutb.loffe.recipe_db.entity.Ingredient;

public interface CreateIngredient {
    @Transactional
    Ingredient createAndSave(String ingredientName);
}
