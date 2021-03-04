package com.netcracker.validators;
import com.netcracker.contract.Contract;

import static com.netcracker.validators.Status.*;

/**
 * Класс проверяет Person
 */
public class PersonValidator extends Validator {
    public PersonValidator() {}

    private static final int MIN_NAME_LENGTH = 2;
    private static final int MAX_NAME_LENGTH = 25;
    private static final int PASSPORT_SERIES_LENGTH = 4;

    /**
     * @param contract контракт
     * @return validate
     */
    @Override
    public Validator validate(Contract contract) {
        if (contract.getClient().getPassportSeries().length() != PASSPORT_SERIES_LENGTH) {
            this.setMessage("Серия паспорта выходит за пределы допустимого значения ");
            this.setStatus(ERROR);
        }
        if (MIN_NAME_LENGTH > contract.getClient().getName().length() || contract.getClient().getName().length() > MAX_NAME_LENGTH) {
            this.setMessage("Имя  выходит за пределы допустимого значения ");
            this.setStatus(RED_RISK);
        }
        else {
            this.setStatus(OK);
        }
        return this;
    }
}
