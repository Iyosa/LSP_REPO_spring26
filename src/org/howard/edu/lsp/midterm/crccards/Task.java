package org.howard.edu.lsp.midterm.crccards;

/**
 * The Task class represents a single task in the management system
 * It stores the ID, description, and current status of a task
 * * @author Iyobosa Eguakun
 */
public class Task {
    private String taskId;
    private String description;
    private String status;

    /**
     * Constructs a new Task with a specified ID and description
     * Default status is "OPEN"
     * * @param taskId the unique ID for the task
     * 
     * @param description a description of the task
     */
    public Task(String taskId, String description) {
        this.taskId = taskId;
        this.description = description;
        this.status = "OPEN";
    }

    /**
     * @return the unique task ID
     */
    public String getTaskId() {
        return taskId;
    }

    /**
     * @return the task description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @return the current status of the task
     */
    public String getStatus() {
        return status;
    }

    /**
     * Updates the task status. Validates against allowed status values
     * If the value is invalid, status is set to "UNKNOWN"
     * * @param status the new status to set "OPEN," "IN_PROGRESS," or "COMPLETE."
     */
    public void setStatus(String status) {
        if (status.equals("OPEN") || status.equals("IN_PROGRESS") || status.equals("COMPLETE")) {
            this.status = status;
        } else {
            this.status = "UNKNOWN";
        }
    }

    /**
     * Returns a string representation of the task in the format:
     * taskId description [status]
     * * @return the formatted task string
     */
    @Override
    public String toString() {
        return taskId + " " + description + " [" + status + "]";
    }
}