package com.simbirsoft.kvashninkirill.exception;

public class ReleaseNotFoundException extends ApplicationNotFoundException {
    public ReleaseNotFoundException(Long id) {
        super("Release with id: " + id + " not found.");
    }
}
