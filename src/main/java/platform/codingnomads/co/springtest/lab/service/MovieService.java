package platform.codingnomads.co.springtest.lab.service;

import platform.codingnomads.co.springtest.lab.entity.Movie;
import platform.codingnomads.co.springtest.lab.exceptions.NoSuchMovieException;

import java.util.List;

public interface MovieService {
    List<Movie> getAllMovies() throws NoSuchMovieException;
}
