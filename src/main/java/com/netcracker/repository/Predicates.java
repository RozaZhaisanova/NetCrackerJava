package com.netcracker.repository;
import java.time.LocalDate;
import java.util.function.Predicate;

import com.netcracker.contract.Contract;
import com.netcracker.person.Person;
/**
 * Класс реализующий предикаты для поиска по критерию
 */
public class Predicates {
    public Predicate<Contract> idPredicate(int id){
        return o->o.getID() == id;
    }

    public Predicate<Contract> numberPredicate(LocalDate beginDate){
        return o->o.getBeginDate() == beginDate;
    }

    public Predicate<Contract> beginDatePredicate(LocalDate endDate){
        return o->o.getEndDate() == endDate;
    }

    public Predicate<Contract> clientPredicate(Person p){
        return o->o.getClient().equals(p);
    }
}