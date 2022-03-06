package com.simbirsoft.kvashninkirill.exception;

public class TaskNotFoundException extends ApplicationNotFoundException {
    public TaskNotFoundException(Long id) {
        super("Task with id: " + id + " not found.");
    }
}
