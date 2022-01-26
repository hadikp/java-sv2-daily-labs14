package day02;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MovieService {

    private List<Movie> movies = new ArrayList<>();

    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    public List<Movie> findMovies(String player) { //Azon filmek listája amiben van a paraméterül átadott színész
        return movies.stream().filter(o -> o.getPlayers().contains(player)).collect(Collectors.toList());
    }

    public int maxLengthMovie() { //leghosszabb film hossza
        return movies.stream().mapToInt(p -> p.getLength()).max().getAsInt(); //.orElseThrow();
    }

    public List<Movie> getMovies() {
        return movies;
    }
}
