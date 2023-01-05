package platform.codingnomads.co.springtest.lab;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import platform.codingnomads.co.springtest.lab.SpringTestLab;
import platform.codingnomads.co.springtest.lab.repository.MovieRepository;

import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(classes = SpringTestLab.class)
@AutoConfigureMockMvc
public class MovieControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    MovieRepository movieRepository;

    @Test
    public void testGetAllMoviesSuccess() throws Exception {
        this.mockMvc.perform(get("/all"))

                //expect status is 200 OK
                .andExpect(status().isOk())

                //expect it will be returned as JSON
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))

                //expect there are 4 entries
                .andExpect(jsonPath("$", hasSize(2)))

                // must add 2 each time before running (or else delete table in db, and write 1)
                .andExpect(jsonPath("$[0].id").value(31))

                .andExpect(jsonPath("$[0].name").value("The Shawshank Redemption"))

                .andExpect(jsonPath("$[0].rating").value(9.3))

                // must add 2 each time before running (or else delete table in db, and write 2)
                .andExpect(jsonPath("$[1].id").value(32))

                .andExpect(jsonPath("$[1].name").value("The Pursuit of Happyness"))

                .andExpect(jsonPath("$[1].rating").value(8));


    }

    @Test
    public void testGetAllMoviesFailure() throws Exception {
        //delete all entries to force error
        movieRepository.deleteAll();

        //perform GET all recipes
        this.mockMvc.perform(get("/all"))

                .andDo(print())

                //expect 404 NOT FOUND
                .andExpect(status().isNotFound())

                //expect error message defined in RecipeService class
                .andExpect(jsonPath("$").value("There are no movies yet :( feel free to add one though"));
    }
//
//    @Test
//    public void testGetAllMoviesSuccessMockService() {
//
//    }
}
