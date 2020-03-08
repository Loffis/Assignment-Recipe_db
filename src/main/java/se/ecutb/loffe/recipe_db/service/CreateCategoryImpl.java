package se.ecutb.loffe.recipe_db.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import se.ecutb.loffe.recipe_db.data.RecipeCategoryRepo;
import se.ecutb.loffe.recipe_db.entity.RecipeCategory;

import java.util.Arrays;
import java.util.Objects;

@Service
public class CreateCategoryImpl implements CreateCategory {

    private RecipeCategoryRepo recipeCategoryRepo;

    @Autowired
    public CreateCategoryImpl(RecipeCategoryRepo recipeCategoryRepo) {
        this.recipeCategoryRepo = recipeCategoryRepo;
    }

    @Override
    @Transactional
    public RecipeCategory createAndSave(String categoryName) {
        if (hasNulls(categoryName)) {
            throw new RuntimeException("Error. Category is null.");
        }
        /*
        if (recipeCategoryRepo.) {
            throw new RuntimeException("Error. Category already exists.");
        }
        */

        RecipeCategory recipeCategory = new RecipeCategory(categoryName);
        return recipeCategoryRepo.save(recipeCategory);
    }

    public static boolean hasNulls(Object...objects) {
        return Arrays.stream(objects)
                .anyMatch(obj -> Objects.isNull(obj));
    }
}
