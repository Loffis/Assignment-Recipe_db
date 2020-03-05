package se.ecutb.loffe.recipe_db.service;

import org.springframework.stereotype.Service;
import se.ecutb.loffe.recipe_db.data.RecipeIngredientRepo;

@Service
public class CreateRecipeIngredientImpl implements CreateRecipeIngredient {

    private RecipeIngredientRepo recipeIngredientRepo;

    //@Autowired
    //public CreateRecipeIngredientImpl(RecipeIngredientRepo recipeIngredientRepo) {
    //    this.recipeIngredientRepo = recipeIngredientRepo;
    //}
/*
    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public RecipeIngredient createAndSave(Ingredient ingredient, double amount, Measurement measurement)  {
        if (hasNulls(ingredient, amount, measurement)) {
            throw new RuntimeException("Error. One or more parameters is null.");
        }

        // TODO check if ingredient already exists

        RecipeIngredient recipeIngredient = new RecipeIngredient(ingredient, amount, measurement);
        return recipeIngredientRepo.save(recipeIngredient);


        // TODO change this!
         return new RecipeIngredient();
    }

    public static boolean hasNulls(Object...objects) {
        return Arrays.stream(objects)
                .anyMatch(obj -> Objects.isNull(obj));
    }
*/
}
