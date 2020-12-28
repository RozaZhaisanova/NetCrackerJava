package com.netcracker.validators;

import com.netcracker.contract.Contract;

/**
 * Абстрактный класс для проверки
 */
public abstract class Validator {

    private String message;
    private Status status;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    abstract public Validator validate(Contract contract);


}