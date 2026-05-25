package model;

public class Task {
    
    private String taskId;
    private String title;
    private String description;
    private TaskStatus status;
    
    public Task(String taskId, String title, String description) {
        this.taskId = taskId;
        this.title = title;
        this.description = description;
        this.status = TaskStatus.PENDING;
    }
    
    // Getters
    public String getTaskId() {
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
    public void setTaskId(String taskId) {
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
    
    @Override
    public String toString() {
        return "Task ID: " + taskId +
                ", Title: " + title +
                ", Description: " + description +
                ", Status: " + status;
    }
}
