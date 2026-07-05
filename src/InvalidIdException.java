/**
 * Thrown when a book ID or member ID entered by the user does not exist in the system.
 */
public class InvalidIdException extends Exception {
    public InvalidIdException(String message) {
        super(message);
    }
}
