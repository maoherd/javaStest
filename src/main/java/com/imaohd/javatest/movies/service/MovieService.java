package com.imaohd.javatest.movies.service;

import com.imaohd.javatest.movies.data.MovieRepository;
import com.imaohd.javatest.movies.model.Genre;
import com.imaohd.javatest.movies.model.Movie;
import java.util.Collection;
import java.util.stream.Collectors;

public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(final MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Collection<Movie> findMoviesByGenre(final Genre genre) {

        return movieRepository.findAll().stream()
            .filter(movie -> movie.getGenre() == genre).collect(Collectors.toList());
    }

    public Collection<Movie> findMoviesByLength(final int length) {
        return movieRepository.findAll().stream()
            .filter(movie -> movie.getMinutes() <= length).collect(Collectors.toList());
    }
}
