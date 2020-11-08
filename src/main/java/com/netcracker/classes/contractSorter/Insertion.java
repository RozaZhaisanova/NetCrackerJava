package com.netcracker.classes.contractSorter;

import com.netcracker.classes.contract.Contract;

import java.util.Comparator;
/**
 * Класс реализующий сортировку вставками
 */
public class Insertion implements ISorter{
    @Override

    public void sort(Contract[] contracts, Comparator<Contract> comparator)
    {
        Contract temp;
        int j;
        for(int i = 0; i < contracts.length - 1; i++){
            if (comparator.compare(contracts[i], contracts[i+1]) > 0) {
                temp = contracts[i + 1];
                contracts[i + 1] = contracts[i];
                j = i;
                while (j > 0 && comparator.compare(temp, contracts[j-1]) < 0) {
                    contracts[j] = contracts[j - 1];
                    j--;
                }
                contracts[j] = temp;
            }
        }

    }
}
