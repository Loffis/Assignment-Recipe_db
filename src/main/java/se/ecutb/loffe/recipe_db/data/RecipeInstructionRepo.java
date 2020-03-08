package se.ecutb.loffe.recipe_db.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.ecutb.loffe.recipe_db.entity.RecipeInstruction;

@Repository
public interface RecipeInstructionRepo extends JpaRepository<RecipeInstruction, String> {
}
