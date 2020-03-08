package se.ecutb.loffe.recipe_db.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import se.ecutb.loffe.recipe_db.data.IngredientRepo;
import se.ecutb.loffe.recipe_db.entity.Ingredient;

import java.util.Arrays;
import java.util.Objects;

@Service
public class CreateIngredientImpl implements CreateIngredient {
    
    private IngredientRepo ingredientRepo;
    
    @Autowired 
    public CreateIngredientImpl(IngredientRepo ingredientRepo) {
        this.ingredientRepo = ingredientRepo;
    }
    
    @Override
    @Transactional
    public Ingredient createAndSave(String ingredientName) {
        if (hasNulls(ingredientName)) {
            throw new RuntimeException("Error. Ingredient name cannot be null.");
        }
        if (ingredientRepo.findByIngredientNameIgnoreCase(ingredientName).isPresent()) {
            throw new RuntimeException("Error. An ingredient with that name already exists.");
        }

        Ingredient ingredient = new Ingredient(ingredientName);
        return ingredientRepo.save(ingredient);
    }

    public static boolean hasNulls(Object...objects) {
        return Arrays.stream(objects)
                .anyMatch(obj -> Objects.isNull(obj));
    }
}
