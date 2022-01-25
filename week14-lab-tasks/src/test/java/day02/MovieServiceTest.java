package day02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MovieServiceTest {
    Movie m1 = new Movie("movie1", 100, List.of("actor1", "actor2", "actor3"));
    Movie m2 = new Movie("movie2", 110, List.of("actor3", "actor4", "actor5"));
    Movie m3 = new Movie("movie3", 120, List.of("actor1", "actor3"));
    Movie m4 = new Movie("movie4", 130, List.of("actor5", "actor6", "actor2", "actor4"));
    MovieService movieService = new MovieService();

    @BeforeEach
    void init() {
        movieService.addMovie(m3);
        movieService.addMovie(m4);
        movieService.addMovie(m2);
        movieService.addMovie(m1);
    }

    @Test
    void findMovieByActor() {
        List<Movie> actual = movieService.findMovieByActor("actor5");
        assertEquals(2, actual.size());
        assertSame(m4, actual.get(0));
        assertSame(m2, actual.get(1));
    }

    @Test
    void longestMovieLength() {
        int actual = movieService.longestMovieLength();
        assertEquals(130, actual);
    }
}