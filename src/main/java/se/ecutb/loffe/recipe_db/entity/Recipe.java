package se.ecutb.loffe.recipe_db.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int recipeId;

    private String recipeName;

    @OneToMany(mappedBy = "recipe", orphanRemoval = true, fetch = FetchType.EAGER,
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE}
    )
    private List<RecipeIngredient> recipeIngredients = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "instruction_id")
    private RecipeInstruction instruction;

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(
            name = "recipes_categories",
            joinColumns = @JoinColumn(name = "recipe_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private List<RecipeCategory> categories = new ArrayList<>();

    public Recipe(int recipeId, String recipeName, List<RecipeIngredient> recipeIngredients,
                  RecipeInstruction instruction, List<RecipeCategory> categories) {
        this.recipeId = recipeId;
        this.recipeName = recipeName;
        setRecipeIngredients(recipeIngredients);
        this.instruction = instruction;
        setCategories(categories);
    }

    public Recipe(String recipeName, List<RecipeIngredient> recipeIngredients, RecipeInstruction instruction,
                  List<RecipeCategory> categories) {
        this(0, recipeName, recipeIngredients, instruction, categories);
    }

    public Recipe(String recipeName) {
        this(0, recipeName, null, null, null);
    }

    public Recipe(){}

    public int getRecipeId() {
        return recipeId;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public List<RecipeIngredient> getRecipeIngredients() {
        return recipeIngredients;
    }

    public void setRecipeIngredients(List<RecipeIngredient> recipeIngredients) {
        if (recipeIngredients == null) {
            recipeIngredients = new ArrayList<>();
        }
        this.recipeIngredients = recipeIngredients;
    }

    public RecipeInstruction getInstruction() {
        return instruction;
    }

    public void setInstruction(RecipeInstruction instruction) {
        this.instruction = instruction;
    }

    public List<RecipeCategory> getCategories() {
        return categories;
    }

    public void setCategories(List<RecipeCategory> categories) {
        if (categories == null) {
            categories = new ArrayList<>();
        }
        this.categories = categories;
    }

    public boolean addCategory(RecipeCategory category) {
        if (category == null) return false;
        if (categories.contains(category)) return false;

        categories.add(category);
        category.getRecipes().add(this);
        return true;
    }

    public boolean removeCategory(RecipeCategory category) {
        if (category == null) return false;
        if (categories == null) return false;

        category.setCategory(null);
        return categories.remove(category);
    }

    public boolean addRecipeIngredient(RecipeIngredient recipeIngredient) {
        if (recipeIngredient == null) return false;
        if (recipeIngredients.contains(recipeIngredient)) return false;

        recipeIngredients.add(recipeIngredient);
        recipeIngredient.setRecipe(this);
        return true;
    }

    public boolean removeRecipeIngredient(RecipeIngredient ingredient) {
        if (ingredient == null) return false;
        if (recipeIngredients == null) return false;

        ingredient.setIngredient(null);
        return recipeIngredients.remove(ingredient);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipe recipe = (Recipe) o;
        return recipeId == recipe.recipeId &&
                Objects.equals(recipeName, recipe.recipeName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recipeId, recipeName);
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "recipeId=" + recipeId +
                ", recipeName='" + recipeName + '\'' +
                ", categories=" + categories +
                '}' + "\n";
    }
}
