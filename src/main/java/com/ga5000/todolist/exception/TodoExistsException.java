package com.ga5000.todolist.exception;

public class TodoExistsException extends RuntimeException {
    public TodoExistsException(String message) {
        super(message);
    }
}
