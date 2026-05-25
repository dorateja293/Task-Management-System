package exception;

/**
 * Custom exception for when an Employee is not found.
 * Extends Exception - makes it a checked exception.
 */
public class EmployeeNotFoundException extends Exception {
    
    public EmployeeNotFoundException(String message) {
        super(message);
    }
}
