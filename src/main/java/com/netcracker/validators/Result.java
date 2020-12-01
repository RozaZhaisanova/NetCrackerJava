package com.netcracker.validators;

public class Result {
    private String message;
    private Status status;

    /**
     * @param message результат проверки
     */
    public Result(String message) {
        this.message = message;
        this.status = Status.ERROR;
    }

    public Status getStatus() {
        return status;
    }
}