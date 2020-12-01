package com.netcracker.validators;

import com.netcracker.contract.Internet;

import java.util.LinkedList;
import java.util.List;

public class InternetContractValidator extends Validator<Internet> {
    private static final int MIN_SPEED = 65;
    private static final int MAX_SPEED = 1600;
    private ContractValidator contractValidator = new ContractValidator();

    /**
     * @param internet контракт
     * @return результат проверки
     */
    @Override
    public List<Result> validate(Internet internet) {
        List<Result> result = new LinkedList<>();

        result.addAll(contractValidator.validate(internet));
        result.addAll(checkMaxSpeed(internet.getMaxSpeed()));
        return result;
    }

    /**
     * @param maxSpeed максимальная скорость интернета
     * @return результат проверки
     */
    public List<Result> checkMaxSpeed(int maxSpeed) {
        List<Result> result = new LinkedList<>();


        if (MAX_SPEED<maxSpeed ||maxSpeed < MIN_SPEED ){
            result.add(new Result("Максимальная скорость  " + maxSpeed + " выходит за пределы допустимого значения " ));
        }

        return result;
    }

}
