package com.cleyton.manage_cars.exception;

public class EmailUniqueViolationException extends RuntimeException {
    public EmailUniqueViolationException(String message) {
        super(message);
    }
}
