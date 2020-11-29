package com.netcracker.validators;

import com.netcracker.contract.Contract;
import com.netcracker.enums.Gender;

import java.time.LocalDate;
/**
 * Класс проверяет Person
 */
public class PersonValidator extends Validator {
    /**
     * Возвращает объект Validator
     *  @param contract контракт
     *  @return Validator
     */
    @Override
    public Validator validator(Contract contract) {
        LocalDate now = LocalDate.now();
        if (contract.getClient().getName().equals("")) {
            this.setMessage("Имя пусто");
            this.setStatus("error");
            this.setMistake("Паспорт клиента: "+contract.getClient().getPassportSeries()+" "+contract.getClient().getPassportNumber());
        } else if (contract.getClient().getDateOfBirth().compareTo(now) > 0) {
            this.setMessage("Дата рождения позже настоящего момента");
            this.setStatus("error");
            this.setMistake(contract.getClient().getDateOfBirth().toString());
        } else if (contract.getClient().getPassportSeries().length() != 4 ||
            10000>contract.getClient().getPassportNumber()||contract.getClient().getPassportNumber()>99999) {
            this.setMessage("Неверные паспортные данные");
            this.setStatus("warning");
            this.setMistake(contract.getClient().getPassportNumber()+ " " +
                    contract.getClient().getPassportSeries());
        } else {
            this.setMessage("Успешно");
            this.setStatus("successful");
            this.setMistake("Вы молодец");}
        return this;
    }
}
