package com.netcracker.classes;

import com.netcracker.classes.contract.Contract;
import com.netcracker.classes.repository.Repository;

import java.util.function.Predicate;

public interface ISearcher<T>{

    public Repository Search(Contract[] contracts, Predicate<Contract> pred);

}