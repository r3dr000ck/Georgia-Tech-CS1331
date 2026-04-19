/**
 * Represents a rentable media item.
 *
 * @author Keigo Yoshioka
 * @version 1.0
 */
public abstract class Media implements Comparable<Media> {
    private Genre genre;
    private String name;
    private int rating;
    private double rentalPrice;

    /**
     * Constructs a media item with all fields specified.
     *
     * @param genre the genre of the media item
     * @param name the name of the media item
     * @param rating the audience rating of the media item
     * @param rentalPrice the rental price of the media item
     */
    public Media(Genre genre, String name, int rating, double rentalPrice) {
        this.genre = genre;
        this.name = name;
        this.rating = rating;
        this.rentalPrice = rentalPrice;
    }

    /**
     * Constructs a media item with the default rental price.
     *
     * @param genre the genre of the media item
     * @param name the name of the media item
     * @param rating the audience rating of the media item
     */
    public Media(Genre genre, String name, int rating) {
        this(genre, name, rating, 7.0);
    }

    /**
     * Returns the name of this media item.
     *
     * @return the media name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Returns the audience rating of this media item.
     *
     * @return the media rating
     */
    public int getRating() {
        return this.rating;
    }

    /**
     * Returns the rental price of this media item.
     *
     * @return the rental price
     */
    public double getRentalPrice() {
        return this.rentalPrice;
    }

    /**
     * Returns a string representation of this media item.
     *
     * @return the formatted media description
     */
    @Override
    public String toString() {
        return String.format(
            "Genre: %s, Name: %s, Rating: %d, Rental Price: $%.2f",
            this.genre, this.name, this.rating, this.rentalPrice
        );
    }

    /**
     * Compares this media item to another object for equality.
     *
     * @param o the object to compare against
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        Media other = (Media) o;
        return this.genre == other.genre
            && this.name.equals(other.name)
            && this.rating == other.rating
            && this.rentalPrice == other.rentalPrice;
    }

    /**
     * Compares this media item to another media item.
     *
     * @param other the other media item
     * @return a positive value if this item is greater, a negative value if it
     *     is smaller, or 0 if they match on the compared fields
     */
    @Override
    public int compareTo(Media other) {
        if (this.genre.compareTo(other.genre) > 0) {
            return 1;
        } else if (this.genre.compareTo(other.genre) < 0) {
            return -1;
        } else {
            if (this.name.compareTo(other.name) > 0) {
                return 1;
            } else if (this.name.compareTo(other.name) < 0) {
                return -1;
            } else {
                if (this.rating > other.rating) {
                    return 1;
                } else if (this.rating < other.rating) {
                    return -1;
                } else {
                    return 0;
                }
            }
        }
    }
}
