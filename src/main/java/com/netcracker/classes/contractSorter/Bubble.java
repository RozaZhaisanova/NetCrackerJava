package com.netcracker.classes.contractSorter;

import com.netcracker.classes.contract.Contract;

import java.util.Comparator;
/**
 * Класс реализующий сортировку пузырьком
 */
public class Bubble implements ISorter {

    @Override
    public void sort(Contract[] contracts, Comparator<Contract> comparator) {
        for (int i = contracts.length - 1; i >= 1; i--) {
            for (int j = 0; j < i; j++) {
                if (comparator.compare(contracts[i], contracts[i - 1]) < 0) {
                    Contract c = contracts[j];
                    contracts[j] = contracts[j + 1];
                    contracts[j + 1] = c;
                }
            }
        }}}


