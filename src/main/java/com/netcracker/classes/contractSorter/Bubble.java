package com.netcracker.classes.contractSorter;

import com.netcracker.classes.contract.Contract;

import java.util.Comparator;

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

   /* @Override
    public void sort(Contract[] contracts, Comparator<Contract> comparator) {
        for(int i = 0; i < contracts.length - 1 && contracts[i] != null; i++){
            for(int j = 0; j < contracts.length - i - 1 && contracts[i] != null; j++){
                if(comparator.compare(contracts[j], contracts[j + 1]) > 0){
                    Contract contract = contracts[j];
                    contracts[j] = contracts[j + 1];
                    contracts[j + 1] = contract;
                }
            }
        }
    }*/



/*
    public void sort(Object[] objects, Comparator comp) {
*/