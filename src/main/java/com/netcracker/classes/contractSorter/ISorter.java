package com.netcracker.classes.contractSorter;

import com.netcracker.classes.contract.Contract;
import com.netcracker.classes.repository.Repository;

import java.util.Comparator;

public interface ISorter {


     public void sort(Contract[] contracts, Comparator<Contract> comparator);
}