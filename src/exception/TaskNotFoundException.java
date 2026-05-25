package exception;

/**
 * Custom exception for when a Task is not found.
 * Extends Exception - makes it a checked exception.
 */
public class TaskNotFoundException extends Exception {
    
    public TaskNotFoundException(String message) {
        super(message);
    }
}
