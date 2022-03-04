package com.imaohd.javatest.movies.data;

import com.imaohd.javatest.movies.model.Movie;
import java.util.Collection;

public interface MovieRepository {

    Movie finById(long id);

    Collection<Movie> findAll();

    void saveOrUpdate(Movie movie);
}
