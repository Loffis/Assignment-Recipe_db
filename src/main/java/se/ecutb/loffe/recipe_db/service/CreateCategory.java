package se.ecutb.loffe.recipe_db.service;

import org.springframework.transaction.annotation.Transactional;
import se.ecutb.loffe.recipe_db.entity.RecipeCategory;

public interface CreateCategory {
    @Transactional
    RecipeCategory createAndSave(String categoryName);
}
