package com.netcracker.validators;
import com.netcracker.contract.Contract;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class ContractValidator extends Validator<Contract> {
    private  PersonValidator personValidator = new PersonValidator();

    /**
     * @param contract контракт
     * @return результат проверки
     */
    @Override
    public List<Result> validate(Contract contract) {
        List<Result> result = new LinkedList<>();
        result.addAll(personValidator.validate(contract.getClient()));
        result.addAll(checkDates(contract.getBeginDate(), contract.getEndDate()));
        return result;
    }

    /**
     * @param beginDate дата начала контракта
     * @param endDate дата конца контракта
     * @return результат проверки
     */
    public List<Result> checkDates(LocalDate beginDate, LocalDate endDate) {
        List<Result> result = new LinkedList<>();

        if (beginDate.isAfter(endDate)) {
            result.add(new Result("Начало контракта " + beginDate + " раньше конца контракта" + endDate));
        }
        else if (beginDate.compareTo(endDate) == 0) {
            result.add(new Result("Начало контракта " + beginDate + " и конец контракта " + endDate+" равны"));
        }
        return result;
    }


}