package com.netcracker.validators;
import com.netcracker.contract.Contract;

import static com.netcracker.validators.Status.*;

public class ContractValidator extends Validator {
    public ContractValidator() {}
    /**
     * @param contract контракт
     * @return validate
     */
    @Override
    public Validator validate(Contract contract) {
        if (contract.getBeginDate().isAfter(contract.getEndDate())) {
            this.setMessage("Начало контракта раньше конца контракта" );
            this.setStatus(ERROR);

        } else if (contract.getBeginDate().compareTo(contract.getEndDate()) == 0) {
            this.setMessage("Начало контракта и конец контракта равны");
            this.setStatus(RED_RISK);

        } else {
            this.setStatus(OK);
        }
        return this;
    }


}