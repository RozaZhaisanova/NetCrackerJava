package com.netcracker.contractSorter;

import com.netcracker.contract.Contract;
import java.util.Comparator;
/**
 * Интерфейс для сортировки
 */
public interface ISorter {
     public void sort(Contract[] contracts, Comparator<Contract> comparator);
}