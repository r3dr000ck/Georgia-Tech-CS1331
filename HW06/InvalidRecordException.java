/**
 * Exception thrown when an invalid record is encountered.
 *
 * @author Keigo
 * @version 1.0
 */
public class InvalidRecordException extends Exception {
    /**
     * Constructs an exception with a custom message.
     *
     * @param message the exception message
     */
    public InvalidRecordException(String message) {
        super(message);
    }

    /**
     * Constructs an exception with the default message.
     */
    public InvalidRecordException() {
        super("Invalid Record");
    }
}
