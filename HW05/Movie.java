/**
 * Represents a movie in the Blockbuster inventory.
 *
 * @author Keigo Yoshioka
 * @version 1.0
 */
public class Movie extends Media {
    private int runtime;

    /**
     * Constructs a movie with all fields specified.
     *
     * @param genre the genre of the movie
     * @param name the name of the movie
     * @param rating the audience rating of the movie
     * @param rentalPrice the rental price of the movie
     * @param runtime the runtime of the movie in minutes
     */
    public Movie(Genre genre, String name, int rating,
        double rentalPrice, int runtime) {
        super(genre, name, rating, rentalPrice);
        this.runtime = runtime;
    }

    /**
     * Constructs a movie with the default rental price and runtime.
     *
     * @param genre the genre of the movie
     * @param name the name of the movie
     * @param rating the audience rating of the movie
     */
    public Movie(Genre genre, String name, int rating) {
        this(genre, name, rating, 5.0, 111);
    }

    /**
     * Returns a string representation of this movie.
     *
     * @return the formatted movie description
     */
    @Override
    public String toString() {
        return String.format("%s, Runtime: %d", super.toString(), this.runtime);
    }

    /**
     * Compares this movie to another object for equality.
     *
     * @param o the object to compare against
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        Movie other = (Movie) o;
        return this.runtime == other.runtime;
    }
}
