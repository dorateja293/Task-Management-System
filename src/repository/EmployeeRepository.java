package repository;

import model.Employee;
import java.util.ArrayList;

/**
 * EmployeeRepository class manages employee data storage and retrieval.
 * Uses ArrayList for in-memory storage.
 */
public class EmployeeRepository {
    
    private ArrayList<Employee> employees;
    
    /**
     * Constructor - Initialize the ArrayList
     */
    public EmployeeRepository() {
        this.employees = new ArrayList<>();
    }
    
    /**
     * Add a new employee to the repository
     * @param employee Employee object to add
     */
    public void addEmployee(Employee employee) {
        employees.add(employee);
        System.out.println("✓ Employee added successfully: " + employee.getName());
    }
    
    /**
     * Remove an employee by employee ID
     * @param employeeId ID of employee to remove
     * @return true if removed, false if not found
     */
    public boolean removeEmployee(String employeeId) {
        for (Employee emp : employees) {
            if (emp.getEmployeeId().equals(employeeId)) {
                employees.remove(emp);
                System.out.println("✓ Employee removed: " + emp.getName());
                return true;
            }
        }
        System.out.println("✗ Employee not found: " + employeeId);
        return false;
    }
    
    /**
     * Find an employee by ID
     * @param employeeId ID to search for
     * @return Employee object if found, null otherwise
     */
    public Employee findEmployeeById(String employeeId) {
        for (Employee emp : employees) {
            if (emp.getEmployeeId().equals(employeeId)) {
                return emp;
            }
        }
        return null;
    }
    
    /**
     * Display all employees in the repository
     */
    public void displayEmployees() {
        if (employees.isEmpty()) {
            System.out.println("\n--- No Employees Found ---");
            return;
        }
        
        System.out.println("\n--- Employee List ---");
        for (int i = 0; i < employees.size(); i++) {
            System.out.println((i + 1) + ". " + employees.get(i));
        }
        System.out.println("Total Employees: " + employees.size());
    }
    
    /**
     * Get total number of employees
     * @return count of employees
     */
    public int getTotalEmployees() {
        return employees.size();
    }
}
