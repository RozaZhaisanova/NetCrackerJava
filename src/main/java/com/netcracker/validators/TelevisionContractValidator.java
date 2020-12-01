package com.netcracker.validators;

import com.netcracker.contract.Television;
import com.netcracker.enums.ChannelPackage;

import java.util.LinkedList;
import java.util.List;

public class TelevisionContractValidator extends Validator<Television> {
    private  ContractValidator contractValidator = new ContractValidator();

    /**
     * @param television контракт
     * @return  результат проверки
     */
     @Override
    public List<Result> validate(Television television) {
        List<Result> result = new LinkedList<>();
        result.addAll(contractValidator.validate(television));
        result.addAll(checkChannelPackage(television.getChannelPackage()));
        return result;
    }
    /**
     * @param channelPackage пакет каналов
     * @return результат проверки
     */
    public List<Result> checkChannelPackage(ChannelPackage channelPackage) {
        List<Result> result = new LinkedList<>();
        if (channelPackage == null){
            result.add(new Result("Пакет каналов " + channelPackage + " выходит за пределы допустимого значения " ));
        }
        return result;
    }

}