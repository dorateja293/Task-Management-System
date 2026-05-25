package model;

/**
 * Manager class extends Employee.
 * Demonstrates inheritance and code reuse.
 * A Manager IS-A Employee + has additional responsibilities.
 */
public class Manager extends Employee {
    
    private int teamSize;
    
    /**
     * Constructor for Manager
     * @param employeeId unique identifier
     * @param name manager name
     * @param department department name
     * @param teamSize number of members in team
     */
    public Manager(String employeeId, String name, String department, int teamSize) {
        super(employeeId, name, department);  // Call parent (Employee) constructor
        this.teamSize = teamSize;
    }
    
    // Getters
    public int getTeamSize() {
        return teamSize;
    }
    
    // Setters
    public void setTeamSize(int teamSize) {
        this.teamSize = teamSize;
    }
    
    /**
     * Override toString() to include teamSize
     */
    @Override
    public String toString() {
        return super.toString() +
                ", Team Size: " + teamSize +
                " [Manager]";
    }
}
