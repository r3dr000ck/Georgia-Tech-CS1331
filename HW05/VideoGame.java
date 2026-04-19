/**
 * Represents a video game in the Blockbuster inventory.
 *
 * @author Keigo Yoshioka
 * @version 1.0
 */
public class VideoGame extends Media {
    private int maxPlayers;
    private boolean needsConsole;

    /**
     * Constructs a video game with all fields specified.
     *
     * @param genre the genre of the video game
     * @param name the name of the video game
     * @param rating the audience rating of the video game
     * @param rentalPrice the rental price of the video game
     * @param maxPlayers the maximum number of players
     * @param needsConsole whether the game requires a console
     */
    public VideoGame(Genre genre, String name, int rating,
        double rentalPrice, int maxPlayers, boolean needsConsole) {
        super(genre, name, rating, rentalPrice);
        this.maxPlayers = maxPlayers;
        this.needsConsole = needsConsole;
    }

    /**
     * Constructs a video game with default values for the remaining fields.
     *
     * @param genre the genre of the video game
     * @param name the name of the video game
     * @param rating the audience rating of the video game
     */
    public VideoGame(Genre genre, String name, int rating) {
        this(genre, name, rating, 5.0, 2, false);
    }

    /**
     * Returns whether this game requires a console.
     *
     * @return true if a console is required, false otherwise
     */
    public boolean getNeedsConsole() {
        return this.needsConsole;
    }

    /**
     * Returns a string representation of this video game.
     *
     * @return the formatted video game description
     */
    @Override
    public String toString() {
        return String.format(
            "%s, Players: %d, %s need a console",
            super.toString(),
            this.maxPlayers,
            this.needsConsole ? "does" : "does not"
        );
    }

    /**
     * Compares this video game to another object for equality.
     *
     * @param o the object to compare against
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        VideoGame other = (VideoGame) o;
        return this.maxPlayers == other.maxPlayers
            && this.needsConsole == other.needsConsole;
    }
}
