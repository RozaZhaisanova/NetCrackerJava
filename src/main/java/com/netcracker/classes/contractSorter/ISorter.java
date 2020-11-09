package com.netcracker.classes.contractSorter;

import com.netcracker.classes.contract.Contract;
import java.util.Comparator;
/**
 * Интерфейс для сортировки
 */
public interface ISorter {
     public void sort(Contract[] contracts, Comparator<Contract> comparator);
}