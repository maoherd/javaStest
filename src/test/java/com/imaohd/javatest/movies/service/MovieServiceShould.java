package com.imaohd.javatest.movies.service;

import com.imaohd.javatest.movies.data.MovieRepository;
import com.imaohd.javatest.movies.model.Movie;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static com.imaohd.javatest.movies.model.Genre.ACTION;
import static com.imaohd.javatest.movies.model.Genre.COMEDY;
import static com.imaohd.javatest.movies.model.Genre.HORROR;
import static com.imaohd.javatest.movies.model.Genre.THRILLER;
import static org.junit.Assert.assertEquals;

public class MovieServiceShould {

    private MovieRepository movieRepository;
    private MovieService movieService;

    @Before
    public void setUp() throws Exception {

        movieRepository = Mockito.mock(MovieRepository.class);

        Mockito.when(movieRepository.findAll()).thenReturn(
            Arrays.asList(
                new Movie(1, "Dark Knight", 152, ACTION),
                new Movie(2, "Memento", 113, THRILLER),
                new Movie(3, "There's Something About Mary", 119, COMEDY),
                new Movie(4, "Super 8", 112, THRILLER),
                new Movie(5, "Scream", 111, HORROR),
                new Movie(6, "Home Alone", 103, COMEDY),
                new Movie(7, "Matrix", 136, ACTION)
            )
        );

        movieService = new MovieService(movieRepository);
    }

    @Test
    public void return_movies_by_genre() {

        Collection<Movie> movies = movieService.findMoviesByGenre(COMEDY);

        assertEquals(getMovieIds(movies), Arrays.asList(3, 6));
    }

    @Test
    public void return_movies_by_length() {

        Collection<Movie> movies = movieService.findMoviesByLength(119);

        assertEquals(getMovieIds(movies), Arrays.asList(2, 3, 4, 5, 6));
    }

    private List<Integer> getMovieIds(final Collection<Movie> movies) {
        return movies.stream().map(Movie::getId).collect(Collectors.toList());
    }
}