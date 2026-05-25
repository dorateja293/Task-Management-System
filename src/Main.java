import model.Task;
import model.Employee;
import model.Manager;
import model.TaskStatus;
import repository.EmployeeRepository;
import service.TaskService;
import util.FileUtil;
import exception.EmployeeNotFoundException;
import exception.TaskNotFoundException;
import java.util.Scanner;

/**
 * Main class - Console-based Employee Task Management System
 * This is the entry point that ties everything together.
 */
public class Main {
    
    public static void main(String[] args) {
        // Initialize components
        EmployeeRepository employeeRepository = new EmployeeRepository();
        TaskService taskService = new TaskService(employeeRepository);
        Scanner sc = new Scanner(System.in);
        
        // Load existing data from file
        FileUtil.loadEmployeesFromFile(employeeRepository);
        
        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║  Employee Task Management System       ║");
        System.out.println("║  Core Java Project - Learn Java OOP    ║");
        System.out.println("╚════════════════════════════════════════╝\n");
        
        // Menu loop
        boolean running = true;
        while (running) {
            displayMenu();
            System.out.print("Choose an option (1-7): ");
            
            int choice = 0;
            try {
                choice = sc.nextInt();
                sc.nextLine(); // Consume newline
            } catch (Exception e) {
                System.out.println("✗ Invalid input. Please enter a number.");
                sc.nextLine(); // Clear invalid input
                continue;
            }
            
            switch (choice) {
                case 1:
                    addEmployee(sc, employeeRepository);
                    break;
                    
                case 2:
                    employeeRepository.displayEmployees();
                    break;
                    
                case 3:
                    assignTask(sc, employeeRepository, taskService);
                    break;
                    
                case 4:
                    viewTasks(sc, taskService);
                    break;
                    
                case 5:
                    removeTask(sc, taskService);
                    break;
                    
                case 6:
                    saveData(employeeRepository);
                    break;
                    
                case 7:
                    System.out.println("\n✓ Thank you for using Employee Task Management System!");
                    System.out.println("✓ Data saved. Goodbye!\n");
                    running = false;
                    break;
                    
                default:
                    System.out.println("✗ Invalid option. Please try again.\n");
            }
        }
        
        sc.close();
    }
    
    /**
     * Display menu options
     */
    private static void displayMenu() {
        System.out.println("\n--- Main Menu ---");
        System.out.println("1. Add Employee");
        System.out.println("2. View All Employees");
        System.out.println("3. Assign Task");
        System.out.println("4. View Tasks");
        System.out.println("5. Remove Task");
        System.out.println("6. Save Data");
        System.out.println("7. Exit");
    }
    
    /**
     * Add a new employee (regular or manager)
     */
    private static void addEmployee(Scanner sc, EmployeeRepository repo) {
        System.out.println("\n--- Add Employee ---");
        System.out.print("Employee ID: ");
        String empId = sc.nextLine();
        
        System.out.print("Name: ");
        String name = sc.nextLine();
        
        System.out.print("Department: ");
        String dept = sc.nextLine();
        
        System.out.print("Is Manager? (yes/no): ");
        String isManager = sc.nextLine();
        
        if (isManager.equalsIgnoreCase("yes")) {
            System.out.print("Team Size: ");
            int teamSize = sc.nextInt();
            sc.nextLine();
            
            Manager manager = new Manager(empId, name, dept, teamSize);
            repo.addEmployee(manager);
        } else {
            Employee employee = new Employee(empId, name, dept);
            repo.addEmployee(employee);
        }
    }
    
    /**
     * Assign a task to an employee
     */
    private static void assignTask(Scanner sc, EmployeeRepository repo, TaskService service) {
        System.out.println("\n--- Assign Task ---");
        System.out.print("Employee ID: ");
        String empId = sc.nextLine();
        
        Employee emp = repo.findEmployeeById(empId);
        if (emp == null) {
            System.out.println("✗ Employee not found!");
            return;
        }
        
        System.out.print("Task ID: ");
        String taskId = sc.nextLine();
        
        System.out.print("Task Title: ");
        String title = sc.nextLine();
        
        System.out.print("Task Description: ");
        String desc = sc.nextLine();
        
        Task task = new Task(taskId, title, desc);
        
        try {
            service.assignTask(empId, task);
        } catch (EmployeeNotFoundException e) {
            System.out.println("✗ Error: " + e.getMessage());
        }
    }
    
    /**
     * View all tasks for an employee
     */
    private static void viewTasks(Scanner sc, TaskService service) {
        System.out.println("\n--- View Tasks ---");
        System.out.print("Employee ID: ");
        String empId = sc.nextLine();
        
        try {
            service.displayTasks(empId);
        } catch (EmployeeNotFoundException e) {
            System.out.println("✗ Error: " + e.getMessage());
        }
    }
    
    /**
     * Remove a task from an employee
     */
    private static void removeTask(Scanner sc, TaskService service) {
        System.out.println("\n--- Remove Task ---");
        System.out.print("Employee ID: ");
        String empId = sc.nextLine();
        
        System.out.print("Task ID to remove: ");
        String taskId = sc.nextLine();
        
        try {
            service.removeTask(empId, taskId);
        } catch (Exception e) {
            System.out.println("✗ Error: " + e.getMessage());
        }
    }
    
    /**
     * Save data to file
     */
    private static void saveData(EmployeeRepository repo) {
        System.out.println("\n--- Saving Data ---");
        FileUtil.saveEmployeesToFile(repo);
    }
}
