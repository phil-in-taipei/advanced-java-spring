package platform.codingnomads.co.springtest.lab;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import platform.codingnomads.co.springtest.TestUtil;
import platform.codingnomads.co.springtest.lab.SpringTestLab;
import platform.codingnomads.co.springtest.lab.entity.Movie;
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
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MovieControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    MovieRepository movieRepository;

    @Test
    @Order(1)
    public void testGetAllMoviesSuccess() throws Exception {
        this.mockMvc.perform(get("/all"))

                //expect status is 200 OK
                .andExpect(status().isOk())

                //expect it will be returned as JSON
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))

                //expect there are 4 entries
                .andExpect(jsonPath("$", hasSize(2)))

                // must add 2 each time before running (or else delete table in db, and write 1)
                .andExpect(jsonPath("$[0].id").value(43))

                .andExpect(jsonPath("$[0].name").value("The Shawshank Redemption"))

                .andExpect(jsonPath("$[0].rating").value(9.3))

                // must add 2 each time before running (or else delete table in db, and write 2)
                .andExpect(jsonPath("$[1].id").value(44))

                .andExpect(jsonPath("$[1].name").value("The Pursuit of Happyness"))

                .andExpect(jsonPath("$[1].rating").value(8));


    }

    @Test
    @Order(2)
    public void testGetAllMoviesSuccessJSONBytesMethod() throws Exception {
        MvcResult mvcResult = this.mockMvc.perform(get("/all"))
                //expect 200 OK
                .andExpect(status().isOk())
                //expect JSON in return
                .andExpect(content().contentType("application/json"))
                //return the MvcResult
                .andReturn();

        byte[] jsonByteArray = mvcResult.getResponse().getContentAsByteArray();
        Movie[] returnedMovies = TestUtil.convertJsonBytesToObject(jsonByteArray, Movie[].class);

        Assertions.assertThat(returnedMovies.length).isEqualTo(2);

        for (Movie movie : returnedMovies) {
            Assertions.assertThat(movie).isNotNull();
            Assertions.assertThat(movie.getId()).isNotNull();
            Assertions.assertThat(movie.getName()).contains("The");
        }
    }

    @Test
    @Order(1)
    public void testGetMoviesByRating() throws Exception {
        this.mockMvc.perform(get("/rating/9"))

                //expect status is 200 OK
                .andExpect(status().isOk())

                //expect it will be returned as JSON
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))

                //expect there are 4 entries
                .andExpect(jsonPath("$", hasSize(1)))

                // must add 2 each time before running (or else delete table in db, and write 1)

                // must add 2 each time before running (or else delete table in db, and write 2)
                .andExpect(jsonPath("$[0].id").value(44))

                .andExpect(jsonPath("$[0].name").value("The Pursuit of Happyness"))

                .andExpect(jsonPath("$[0].rating").value(8));


    }

    @Test
    @Order(4)
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
