import java.util.ArrayList;

/**
 * Represents a movie theater's current and watched movie lists.
 *
 * @author Keigo Yoshioka
 * @version 1.0
 */
public class MovieTheater {
    private ArrayList<String> movies;
    private ArrayList<String> watched;

    /**
     * Constructs a movie theater with copies of the provided lists.
     *
     * @param movies the movies currently playing
     * @param watched the movies that have already been watched
     */
    public MovieTheater(ArrayList<String> movies, ArrayList<String> watched) {
        if (movies == null) {
            this.movies = new ArrayList<String>();
        } else {
            this.movies = new ArrayList<String>(movies);
        }

        if (watched == null) {
            this.watched = new ArrayList<String>();
        } else {
            this.watched = new ArrayList<String>(watched);
        }
    }

    /**
     * Throws an exception if any interesting movie is not currently playing.
     *
     * @param interestingMovies the movies to check
     * @throws FilmNotFoundException if any movie is not in the theater
     */
    public void throwIfMoviesMissing(ArrayList<String> interestingMovies)
            throws FilmNotFoundException {
        if (interestingMovies == null) {
            throw new IllegalArgumentException("Your List Is NULL!");
        }

        for (int i = 0; i < interestingMovies.size(); i++) {
            if (!this.movies.contains(interestingMovies.get(i))) {
                throw new FilmNotFoundException(interestingMovies.get(i));
            }
        }
    }

    /**
     * Watches a movie if it is playing and has not already been watched.
     *
     * @param movie the movie to watch
     * @throws FilmNotFoundException if the movie is not currently playing
     */
    public void watchMovie(String movie) throws FilmNotFoundException {
        if (movie == null) {
            throw new IllegalArgumentException("The Movie is NULL!");
        }

        if (!this.movies.contains(movie)) {
            throw new FilmNotFoundException(movie);
        }

        if (this.watched.contains(movie)) {
            throw new AlreadyWatchedException();
        }

        this.movies.remove(movie);
        this.watched.add(movie);
    }

    /**
     * Returns recommended movies that are playing and not yet watched.
     *
     * @param recommendedMovies the recommended movies to filter
     * @return the recommended movies that can still be watched
     */
    public ArrayList<String> selectRecommended(ArrayList<String> recommendedMovies) {
        ArrayList<String> willSee = new ArrayList<String>();

        if (recommendedMovies == null) {
            throw new IllegalArgumentException("Your List Is NULL!");
        }

        for (int i = 0; i < recommendedMovies.size(); i++) {
            String movie = recommendedMovies.get(i);
            if (this.movies.contains(movie) && !this.watched.contains(movie)) {
                willSee.add(movie);
            }
        }

        return willSee;
    }

    /**
     * Runs a small example of the theater methods.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        ArrayList<String> movies = new ArrayList<String>();
        movies.add("Dune");
        movies.add("Barbie");
        movies.add("Inception");
        movies.add("Spider-Man");
        movies.add("Tenet");

        ArrayList<String> watched = new ArrayList<String>();
        watched.add("Dune");
        watched.add("Titanic");

        ArrayList<String> recommended = new ArrayList<String>();
        recommended.add("Barbie");
        recommended.add("Dune");
        recommended.add("Avatar");

        MovieTheater theater = new MovieTheater(movies, watched);

        try {
            theater.throwIfMoviesMissing(movies);
            theater.watchMovie("Barbie");
            theater.watchMovie("Titanic");
            theater.watchMovie("Avatar");

            ArrayList<String> willSee = theater.selectRecommended(recommended);
            for (String movie : willSee) {
                System.out.println(movie);
            }
        } catch (FilmNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (AlreadyWatchedException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Took a look at the movies!");
        }
    }
}
