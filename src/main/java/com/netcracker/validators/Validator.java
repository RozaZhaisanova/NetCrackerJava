package com.netcracker.validators;

import com.netcracker.contract.Contract;
/**
 * Абстрактный класс для проверки контракта
 */
public abstract class Validator {
    private String message;
    private String status;
    private String mistake;

    public String getMistake() {
        return mistake;
    }

    public void setMistake(String mistake) {
        this.mistake = mistake;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String errorStatus) {
        this.status = errorStatus;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    abstract public Validator validator(Contract contract);

    @Override
    public String toString() {

        return "Сообщение: " + message + ", статус: " + status + ", потому что " + mistake ;
    }
    public static void validation(Validator[] validators, Contract contract) {
        for (Validator validator : validators) {
            System.out.println(validator.validator(contract));
        }
    }

}