package org.howard.edu.lsp.midterm.crccards;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Manages a collection of Task objects using a Map to ensure unique IDs
 * * @author Iyobosa Eguakun
 */
public class TaskManager {

    private Map<String, Task> tasks;

    /**
     * Initializes the internal task storage
     */
    public TaskManager() {
        this.tasks = new HashMap<>();
    }

    /**
     * Stores a task; throws exception if ID already exists
     * * @param task the Task object to be added
     * 
     * @throws IllegalArgumentException if taskId is a duplicate
     */
    public void addTask(Task task) {
        if (tasks.containsKey(task.getTaskId())) {
            throw new IllegalArgumentException("Duplicate task ID: " + task.getTaskId());
        }
        tasks.put(task.getTaskId(), task);
    }

    /**
     * Finds a task by its ID
     * * @param taskId the ID to search for
     * 
     * @return the Task if found, or null if not found
     */
    public Task findTask(String taskId) {
        return tasks.get(taskId);
    }

    /**
     * Returns all tasks matching a specific status
     * * @param status the status to filter by
     * 
     * @return a List of tasks with the matching status
     */
    public List<Task> getTasksByStatus(String status) {
        List<Task> result = new ArrayList<>();
        for (Task task : tasks.values()) {
            if (task.getStatus().equals(status)) {
                result.add(task);
            }
        }
        return result;
    }
}