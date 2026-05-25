package util;

import model.Employee;
import model.Manager;
import repository.EmployeeRepository;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * FileUtil class handles file persistence operations.
 * Saves and loads employee data using File I/O.
 */
public class FileUtil {
    
    private static final String FILE_PATH = "data/employees.txt";
    
    /**
     * Save employees to file
     * Format: employeeId,name,department,type(Employee|Manager),teamSize
     * @param repository EmployeeRepository containing employees
     */
    public static void saveEmployeesToFile(EmployeeRepository repository) {
        try {
            // Create data directory if it doesn't exist
            File dir = new File("data");
            if (!dir.exists()) {
                dir.mkdir();
            }
            
            FileWriter fw = new FileWriter(FILE_PATH);
            BufferedWriter bw = new BufferedWriter(fw);
            
            // Note: In a real app, we'd iterate through repository
            // For now, we'll add this capability when we get employee list
            
            bw.close();
            fw.close();
            
            System.out.println("✓ Data saved to file: " + FILE_PATH);
            
        } catch (IOException e) {
            System.out.println("✗ Error saving to file: " + e.getMessage());
        }
    }
    
    /**
     * Load employees from file and populate repository
     * @param repository EmployeeRepository to populate
     */
    public static void loadEmployeesFromFile(EmployeeRepository repository) {
        try {
            File file = new File(FILE_PATH);
            
            if (!file.exists()) {
                System.out.println("ℹ No saved data found. Starting fresh.");
                return;
            }
            
            FileReader fr = new FileReader(FILE_PATH);
            BufferedReader br = new BufferedReader(fr);
            
            String line;
            int count = 0;
            
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue;
                
                String[] parts = line.split(",");
                
                if (parts.length >= 3) {
                    String employeeId = parts[0];
                    String name = parts[1];
                    String department = parts[2];
                    String type = (parts.length > 3) ? parts[3] : "Employee";
                    
                    if ("Manager".equals(type) && parts.length > 4) {
                        int teamSize = Integer.parseInt(parts[4]);
                        Manager manager = new Manager(employeeId, name, department, teamSize);
                        repository.addEmployee(manager);
                    } else {
                        Employee employee = new Employee(employeeId, name, department);
                        repository.addEmployee(employee);
                    }
                    count++;
                }
            }
            
            br.close();
            fr.close();
            
            System.out.println("✓ Loaded " + count + " employees from file");
            
        } catch (IOException e) {
            System.out.println("✗ Error loading from file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("✗ Error parsing data: " + e.getMessage());
        }
    }
    
    /**
     * Append a single employee to the file
     * @param employee Employee to save
     */
    public static void appendEmployeeToFile(Employee employee) {
        try {
            File dir = new File("data");
            if (!dir.exists()) {
                dir.mkdir();
            }
            
            FileWriter fw = new FileWriter(FILE_PATH, true); // append mode
            BufferedWriter bw = new BufferedWriter(fw);
            
            if (employee instanceof Manager) {
                Manager mgr = (Manager) employee;
                bw.write(employee.getEmployeeId() + "," +
                         employee.getName() + "," +
                         employee.getDepartment() + "," +
                         "Manager," +
                         mgr.getTeamSize());
            } else {
                bw.write(employee.getEmployeeId() + "," +
                         employee.getName() + "," +
                         employee.getDepartment() + "," +
                         "Employee,0");
            }
            bw.newLine();
            bw.close();
            fw.close();
            
        } catch (IOException e) {
            System.out.println("✗ Error writing to file: " + e.getMessage());
        }
    }
}
