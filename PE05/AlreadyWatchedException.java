/**
 * Thrown when a user tries to watch a movie that has already been watched.
 *
 * @author Keigo Yoshioka
 * @version 1.0
 */
public class AlreadyWatchedException extends RuntimeException {

    /**
     * Constructs an exception with the default message.
     */
    public AlreadyWatchedException() {
        super("You've already seen this movie here!");
    }
}
