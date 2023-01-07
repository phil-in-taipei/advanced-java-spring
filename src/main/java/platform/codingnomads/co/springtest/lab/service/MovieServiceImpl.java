package platform.codingnomads.co.springtest.lab.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import platform.codingnomads.co.springtest.lab.entity.Movie;
import platform.codingnomads.co.springtest.lab.exceptions.NoSuchMovieException;
import platform.codingnomads.co.springtest.lab.repository.MovieRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public ArrayList<Movie> getAllMovies() throws NoSuchMovieException {
        ArrayList<Movie> movies = new ArrayList<Movie>(movieRepository.findAll());
        if (movies.isEmpty()) {
            throw new NoSuchMovieException("There are no movies yet :( feel free to add one though");
        }
        return movies;
    }

    @Override
    public ArrayList<Movie> getMoviesByRating(Double rating) throws NoSuchMovieException {
        ArrayList<Movie> movies = new ArrayList<Movie>(movieRepository.findByRatingLessThanEqual(rating));
        if (movies.isEmpty()) {
            throw new NoSuchMovieException("There are no movies below that rating yet :( feel free to add one though");
        }
        return movies;
    }
}
