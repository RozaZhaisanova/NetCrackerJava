package com.netcracker.validators;

import com.netcracker.contract.Contract;

/**
 * Класс проверяет контракт
 */
public class ContractValidator extends Validator {
    /**
     *  Возвращает объект Validator
     *  @param contract контракт
     *  @return Validator
     */
    @Override
    public Validator validator(Contract contract) {
        if (contract.getBeginDate().compareTo(contract.getEndDate()) > 0 ) {
            this.setMessage("Начало контракта раньше конца контракта");
            this.setStatus("error");
            this.setMistake(contract.getBeginDate()+" "+contract.getEndDate());
        } else if (contract.getBeginDate().compareTo(contract.getEndDate()) == 0) {
            this.setMessage("начало и конец контракта равны");
            this.setStatus("warning");
            this.setMistake(contract.getBeginDate().toString());
        } else {
            this.setMessage("Успешно");
            this.setStatus("successful");
            this.setMistake("Вы молодец");
        }
        return this;
    }

}
