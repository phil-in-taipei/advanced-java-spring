package platform.codingnomads.co.springtest.lab;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import platform.codingnomads.co.springtest.lab.entity.Movie;
import platform.codingnomads.co.springtest.lab.exceptions.NoSuchMovieException;
import platform.codingnomads.co.springtest.lab.repository.MovieRepository;
import platform.codingnomads.co.springtest.lab.service.MovieServiceImpl;
import platform.codingnomads.co.springtest.mockingmethods.exceptions.NoSuchRecipeException;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = SpringTestLab.class)
@ActiveProfiles("test")
public class MovieServiceImplTest {

    @MockBean
    MovieRepository movieRepository;

    @Autowired
    MovieServiceImpl movieServiceImp;

    @Test
    public void testGetAllMoviesByRatingSuccessBehavior() throws Exception {
        Movie movie = Movie.builder().name("The Pursuit of Happyness").rating(8.0).build();
        when(movieRepository.findByRatingLessThanEqual(anyDouble())).thenReturn(
                new ArrayList<>(Collections.singletonList(movie))
        );

        ArrayList<Movie> movies = movieServiceImp.getMoviesByRating(9.0);

        assertThat(movies.size()).isEqualTo(1);
        assertThat(movies.get(0)).isEqualTo(movie);
    }

    @Test
    public void testGetAllMoviesByRatingFailureBehavior() {
        when(movieRepository.findByRatingLessThanEqual(anyDouble())).thenReturn(
                new ArrayList<>()
        );
        assertThrows(NoSuchMovieException.class, () -> {
            movieServiceImp.getMoviesByRating(5.0);
        }, "There are no movies below that rating yet :( feel free to add one though");
    }

    @Test
    public void testGetAllMoviesSuccessBehavior() throws Exception {
        Movie movie = Movie.builder().name("The Shawshank Redemption").rating(9.3).build();
        when(movieRepository.findAll()).thenReturn(new ArrayList<>(Collections.singletonList(movie)));

        ArrayList<Movie> movies = movieServiceImp.getAllMovies();

        assertThat(movies.size()).isEqualTo(1);
        assertThat(movies.get(0)).isEqualTo(movie);
    }

    @Test
    public void testGetAllMoviesFailureBehavior() {
        when(movieRepository.findAll()).thenReturn(new ArrayList<>());
        assertThrows(NoSuchMovieException.class, () -> {
            movieServiceImp.getAllMovies();
        }, "There are no movies yet :( feel free to add one though");
    }


}
