package com.netcracker.validators;

import com.netcracker.contract.Mobile;

import java.util.LinkedList;
import java.util.List;

public class MobileContractValidator extends Validator<Mobile> {
    private static final int MIN_MIN = 100;
    private static final int MAX_MIN = 2000;
    private static final int MIN_MB = 100;
    private static final int MAX_MB = 50000;
    private static final int MIN_SMS = 100;
    private static final int MAX_SMS = 5000;
    private ContractValidator contractValidator = new ContractValidator();
    /**
     * @param mobile контракт
     * @return результат проверки
     */
    @Override
    public List<Result> validate(Mobile mobile) {
        List<Result> result = new LinkedList<>();

        result.addAll(contractValidator.validate(mobile));
        result.addAll(checkMin(mobile.getMin()));
        result.addAll(checkMb(mobile.getMb()));
        result.addAll(checkMb(mobile.getSms()));
        return result;
    }

    /**
     * @param sms  смс
     * @return результат
     */
    public List<Result> checkSms(int sms) {
        List<Result> result = new LinkedList<>();

        if (MIN_SMS >sms|| sms > MAX_SMS) {
            result.add(new Result("Количество смс "+sms +" выходит за пределы допустимого значения"));
        }
        return result;
    }


    /**
     * @param mb  мегабайт
     * @return результат
     */
    public List<Result> checkMb(int mb) {
        List<Result> result = new LinkedList<>();

        if ( MIN_MB >mb|| mb > MAX_MB) {
            result.add(new Result("Количество мегабайт "+mb +" выходит за пределы допустимого значения"));
        }
        return result;
    }


    /**
     * @param min  минуты
     * @return результат
     */
    public List<Result> checkMin(int min) {
        List<Result> result = new LinkedList<>();

        if (  MIN_MIN >min|| min > MAX_MIN) {
            result.add(new Result("Количество минут "+min +" выходит за пределы допустимого значения"));
        }
        return result;
    }

}