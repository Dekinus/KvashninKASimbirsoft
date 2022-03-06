package com.simbirsoft.kvashninkirill.exception;

public class PersonNotFoundException extends ApplicationNotFoundException {
    public PersonNotFoundException(Long id) {
        super("Person with id: " + id + " not found.");
    }
}
