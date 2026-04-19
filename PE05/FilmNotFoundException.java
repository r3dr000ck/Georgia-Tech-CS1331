/**
 * Thrown when a requested movie is not available in the theater.
 *
 * @author Keigo Yoshioka
 * @version 1.0
 */
public class FilmNotFoundException extends Exception {

    /**
     * Constructs an exception for the missing movie.
     *
     * @param movie the movie that could not be found
     */
    public FilmNotFoundException(String movie) {
        super(String.format("%s is not playing at this movie theater.", movie));
    }
}
