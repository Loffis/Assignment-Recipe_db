package se.ecutb.loffe.recipe_db.data;

import org.springframework.data.jpa.repository.JpaRepository;
import se.ecutb.loffe.recipe_db.entity.RecipeInstruction;

public interface RecipeInstructionRepo extends JpaRepository<RecipeInstruction, String> {
}
