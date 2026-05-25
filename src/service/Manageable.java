package service;

import model.Task;

/**
 * Manageable interface defines task management contracts.
 * Any class implementing this must provide task management functionality.
 */
public interface Manageable {
    
    /**
     * Assign a task to an employee
     * @param employeeId ID of employee
     * @param task Task to assign
     */
    void assignTask(String employeeId, Task task) throws Exception;
    
    /**
     * Remove a task from an employee
     * @param employeeId ID of employee
     * @param taskId ID of task to remove
     */
    void removeTask(String employeeId, String taskId) throws Exception;
}
