package se.ecutb.loffe.recipe_db.data;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@DataJpaTest
public class RecipeRepoTest {

    @Autowired
    private RecipeRepo testObject;

    @Autowired
    private TestEntityManager testEM;

    @BeforeEach
    public void setup() {


        testEM.flush();
    }

}
