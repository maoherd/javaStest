package com.imaohd.javatest.movies.data;

import com.imaohd.javatest.movies.model.Genre;
import com.imaohd.javatest.movies.model.Movie;
import java.util.Collection;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class MovieRepositoryJdbc implements MovieRepository {

    private static final RowMapper<Movie> movieMapper = (rs, rowNum) -> new Movie(
        rs.getInt("id"),
        rs.getString("name"),
        rs.getInt("minutes"),
        Genre.valueOf(rs.getString("genre")));
    JdbcTemplate jdbcTemplate;

    public MovieRepositoryJdbc(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Movie finById(final long id) {

        Object[] args = { id };
        return jdbcTemplate.queryForObject("SELECT * FROM movies WHERE id = ?", args, movieMapper);
    }

    @Override
    public Collection<Movie> findAll() {

        return jdbcTemplate.query("SELECT * FROM movies", movieMapper);
    }

    @Override
    public void saveOrUpdate(final Movie movie) {

        jdbcTemplate.update("INSERT INTO movies (name, minutes, genre) values (?, ?, ?)",
            movie.getName(), movie.getMinutes(), movie.getGenre().toString());
    }
}
