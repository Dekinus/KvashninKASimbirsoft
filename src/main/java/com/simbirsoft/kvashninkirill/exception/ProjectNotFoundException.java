package com.simbirsoft.kvashninkirill.exception;

public class ProjectNotFoundException extends ApplicationNotFoundException {
    public ProjectNotFoundException(Long id) {
        super("Project with id: " + id + " not found.");
    }
}
