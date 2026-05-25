package model;

public class Employee {
    
    private String employeeId;
    private String name;
    private String department;
    
    public Employee(String employeeId, String name, String department) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
    }
    
    // Getters
    public String getEmployeeId() {
        return employeeId;
    }
    
    public String getName() {
        return name;
    }
    
    public String getDepartment() {
        return department;
    }
    
    // Setters
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setDepartment(String department) {
        this.department = department;
    }
    
    @Override
    public String toString() {
        return "Employee ID: " + employeeId +
                ", Name: " + name +
                ", Department: " + department;
    }
}
