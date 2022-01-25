package day02;

import java.util.ArrayList;
import java.util.List;

public class MovieService {
    private List<Movie> movies = new ArrayList<>();

    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    public List<Movie> findMovieByActor(String actor) {
        return movies.stream()
                .filter(movie -> movie.getActors().contains(actor))
                .toList();
    }

    public int longestMovieLength() {
        return movies.stream()
                .mapToInt(Movie::getLength)
                .max().orElseThrow(() -> new IllegalArgumentException("Empty list!"));
    }

    public List<Movie> getMovies() {
        return movies;
    }
}
