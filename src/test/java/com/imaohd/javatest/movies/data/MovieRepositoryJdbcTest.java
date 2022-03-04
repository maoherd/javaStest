package com.imaohd.javatest.movies.data;

import com.imaohd.javatest.movies.model.Genre;
import com.imaohd.javatest.movies.model.Movie;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Collection;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.ScriptUtils;

import static org.junit.Assert.assertEquals;

public class MovieRepositoryJdbcTest {

    private static DriverManagerDataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    private MovieRepositoryJdbc movieRepositoryjdbc;

    @Before
    public void setUp() throws SQLException {

        dataSource = new DriverManagerDataSource("jdbc:h2:mem:test;MODE=MYSQL", "sa", "sa");
        ScriptUtils.executeSqlScript(dataSource.getConnection(), new ClassPathResource("sql-scripts/test-data.sql"));
        jdbcTemplate = new JdbcTemplate(dataSource);
        movieRepositoryjdbc = new MovieRepositoryJdbc(jdbcTemplate);
    }

    @Test
    public void load_all_movies() {

        Collection<Movie> movies = movieRepositoryjdbc.findAll();

        assertEquals(Arrays.asList(
            new Movie(1, "Dark Knight", 152, Genre.ACTION),
            new Movie(2, "Memento", 113, Genre.THRILLER),
            new Movie(3, "Matrix", 136, Genre.ACTION)

        ), movies);
    }

    @Test
    public void load_movie_by_id() {
        Movie movie = movieRepositoryjdbc.finById(2);

        assertEquals(
            new Movie(2, "Memento", 113, Genre.THRILLER)
            , movie);
    }

    @Test
    public void insert_a_movie() {
        Movie movie = new Movie("Super 8", 112, Genre.THRILLER);
        movieRepositoryjdbc.saveOrUpdate(movie);

        final Movie movieFromDb = movieRepositoryjdbc.finById(4);

        assertEquals(movieFromDb, new Movie(4, "Super 8", 112, Genre.THRILLER));
    }

    @After
    public void tearDown() throws Exception {

        final Statement s = dataSource.getConnection().createStatement();
        s.execute("drop all objects delete files");
    }
}