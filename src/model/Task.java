package model;

/**
 * Task class represents a task in the Task Management System.
 * Each task has an ID, title, description, and status.
 */
public class Task {
    
    private int taskId;
    private String title;
    private String description;
    private TaskStatus status;
    
    /**
     * Constructor to create a new Task
     * @param taskId unique identifier for the task
     * @param title title of the task
     * @param description detailed description of the task
     * @param status current status of the task (PENDING, IN_PROGRESS, DONE)
     */
    public Task(int taskId, String title, String description, TaskStatus status) {
        this.taskId = taskId;
        this.title = title;
        this.description = description;
        this.status = status;
    }
    
    // Getters
    public int getTaskId() {
        return taskId;
    }
    
    public String getTitle() {
        return title;
    }
    
    public String getDescription() {
        return description;
    }
    
    public TaskStatus getStatus() {
        return status;
    }
    
    // Setters
    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public void setStatus(TaskStatus status) {
        this.status = status;
    }
    
    /**
     * Returns a string representation of the Task
     */
    @Override
    public String toString() {
        return "Task{" +
                "taskId=" + taskId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                '}';
    }
}
