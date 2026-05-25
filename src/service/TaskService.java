package service;

import model.Task;
import model.Employee;
import repository.EmployeeRepository;
import exception.EmployeeNotFoundException;
import exception.TaskNotFoundException;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

/**
 * TaskService class manages task assignments and removal.
 * Uses HashMap to store employee tasks.
 * Implements Manageable interface for polymorphism.
 */
public class TaskService implements Manageable {
    
    private EmployeeRepository employeeRepository;
    
    // HashMap: employeeId -> List of Tasks
    private HashMap<String, List<Task>> employeeTasks;
    
    /**
     * Constructor - Initialize HashMap and repository reference
     * @param employeeRepository Reference to employee repository
     */
    public TaskService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
        this.employeeTasks = new HashMap<>();
    }
    
    /**
     * Assign a task to an employee
     * @param employeeId ID of employee
     * @param task Task to assign
     * @throws EmployeeNotFoundException if employee not found
     */
    @Override
    public void assignTask(String employeeId, Task task) throws EmployeeNotFoundException {
        try {
            Employee emp = employeeRepository.findEmployeeById(employeeId);
            
            if (emp == null) {
                throw new EmployeeNotFoundException("Employee with ID " + employeeId + " not found!");
            }
            
            // Get or create task list for this employee
            employeeTasks.putIfAbsent(employeeId, new ArrayList<>());
            employeeTasks.get(employeeId).add(task);
            
            System.out.println("✓ Task assigned to " + emp.getName() + ": " + task.getTitle());
            
        } catch (EmployeeNotFoundException e) {
            System.out.println("✗ " + e.getMessage());
            throw e;
        }
    }
    
    /**
     * Remove a task from an employee
     * @param employeeId ID of employee
     * @param taskId ID of task to remove
     * @throws EmployeeNotFoundException if employee not found
     * @throws TaskNotFoundException if task not found
     */
    @Override
    public void removeTask(String employeeId, String taskId) throws Exception {
        try {
            Employee emp = employeeRepository.findEmployeeById(employeeId);
            
            if (emp == null) {
                throw new EmployeeNotFoundException("Employee with ID " + employeeId + " not found!");
            }
            
            if (!employeeTasks.containsKey(employeeId)) {
                throw new TaskNotFoundException("No tasks found for employee " + employeeId);
            }
            
            List<Task> tasks = employeeTasks.get(employeeId);
            Task taskToRemove = null;
            
            for (Task task : tasks) {
                if (task.getTaskId().equals(taskId)) {
                    taskToRemove = task;
                    break;
                }
            }
            
            if (taskToRemove == null) {
                throw new TaskNotFoundException("Task with ID " + taskId + " not found!");
            }
            
            tasks.remove(taskToRemove);
            System.out.println("✓ Task removed from " + emp.getName() + ": " + taskToRemove.getTitle());
            
        } catch (Exception e) {
            System.out.println("✗ " + e.getMessage());
            throw e;
        }
    }
    
    /**
     * Display all tasks for an employee
     * @param employeeId ID of employee
     * @throws EmployeeNotFoundException if employee not found
     */
    public void displayTasks(String employeeId) throws EmployeeNotFoundException {
        try {
            Employee emp = employeeRepository.findEmployeeById(employeeId);
            
            if (emp == null) {
                throw new EmployeeNotFoundException("Employee with ID " + employeeId + " not found!");
            }
            
            if (!employeeTasks.containsKey(employeeId) || employeeTasks.get(employeeId).isEmpty()) {
                System.out.println("\n--- No tasks assigned to " + emp.getName() + " ---");
                return;
            }
            
            System.out.println("\n--- Tasks assigned to " + emp.getName() + " ---");
            List<Task> tasks = employeeTasks.get(employeeId);
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
            System.out.println("Total Tasks: " + tasks.size());
            
        } catch (EmployeeNotFoundException e) {
            System.out.println("✗ " + e.getMessage());
            throw e;
        }
    }
    
    /**
     * Get total tasks for an employee
     * @param employeeId ID of employee
     * @return count of tasks
     */
    public int getTotalTasks(String employeeId) {
        if (employeeTasks.containsKey(employeeId)) {
            return employeeTasks.get(employeeId).size();
        }
        return 0;
    }
}
