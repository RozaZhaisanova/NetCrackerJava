package com.netcracker.exceptions;

public class InjectionException extends Exception {
    public InjectionException(Exception e) {
        super(e);
    }
    public InjectionException(String message) {
        super(message);
    }
}