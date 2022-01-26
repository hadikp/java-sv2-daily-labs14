package day02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MovieServiceTest {

    MovieService movieService;
    Movie pok;

    @BeforeEach
    void init() {
        Movie robot = new Movie("Robots", 150, Arrays.asList("Robin", "Andrew", "Jack"));
        Movie halal = new Movie("8. utas a halál", 220, Arrays.asList("Robin", "Jane", "Jack"));
        pok = new Movie("Pókember", 110, Arrays.asList("Tom", "Tobey", "Joe"));
        movieService = new MovieService();
        movieService.addMovie(robot);
        movieService.addMovie(halal);
        movieService.addMovie(pok);
    }

    @Test
    void testFindMovies() {
        assertEquals(Arrays.asList(pok), movieService.findMovies("Tom"));
    }

    @Test
    void testMaxLengthMovie() {
        assertEquals(220, movieService.maxLengthMovie());
    }

}