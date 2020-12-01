package com.netcracker.validators;
import com.netcracker.person.Person;
import java.util.LinkedList;
import java.util.List;

/**
 * Класс проверяет Person
 */
public class PersonValidator extends Validator<Person> {

    private static final int MIN_NAME_LENGTH = 2;
    private static final int MAX_NAME_LENGTH = 25;
    private static final int PASSPORT_SERIES_LENGTH = 4;


    /**
     * @param person клиент
     * @return результат проверки
     */
    @Override
    public List<Result> validate(Person person) {
        List<Result> result = new LinkedList<>();

        result.addAll(checkName(person.getName()));
        result.addAll(checkPassportSeries(person.getPassportSeries()));
        return result;
    }

    /**
     * @param name имя
     * @return результат
     */
    public List<Result> checkName(String name) {
        List<Result> result = new LinkedList<>();

        if ( MIN_NAME_LENGTH > name.length()||name.length() > MAX_NAME_LENGTH) {
            result.add(new Result("Имя  " + name + " выходит за пределы допустимого значения "));
        }

        return result;
    }

    /**
     * @param passportSeries номер паспорта
     * @return результат
     */
    public List<Result> checkPassportSeries(String passportSeries) {
        List<Result> result = new LinkedList<>();

        if (passportSeries.length() != PASSPORT_SERIES_LENGTH) {
            result.add(new Result("Серия паспорта  " + passportSeries + " выходит за пределы допустимого значения "));
        }


        return result;
    }}




