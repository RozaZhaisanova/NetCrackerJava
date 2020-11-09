package com.netcracker.classes.repository;

import com.netcracker.classes.contract.Contract;
import com.netcracker.classes.contractSorter.Bubble;
import com.netcracker.classes.contractSorter.ISorter;
import com.netcracker.classes.contractSorter.Insertion;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Predicate;

public class Repository {
    /**
     * массив контактов
     */
    /**
     * ёмкость массива
     */
    private int capacity = 16;
    private ISorter sort = new Bubble();
    private ISorter sort1 = new Insertion();

    private Contract[] contracts;
    /**
     * Индекс следующей ячейки где программа должна добавить следующий экземпляр при
     * вызове метода add
     */
    private int nextCallIndex = 0;

    /**
     * счетчик для итератора
     */
    private int iteratorIndex = 0;
    /**
     * размер массива
     */
    private int size=0;

    /**
     * Конструктор без параметров создает массив с длиной capacity
     */
    public Repository() {
        this.contracts = new Contract[capacity];
    }

    /**
     * Конструктор с 1 параметром
     *
     * @param capacity начальная длина массива
     *
     */
    public Repository(int capacity) {
        this.capacity = capacity;
        this.contracts = new Contract[capacity];
    }



    /**
     * Добавляет новый экземпляр класса Contact в массив
     *
     * @param contact новый экземпляр который надо добавить
     */
    public void add(Contract contact) {
        if (nextCallIndex >= this.capacity) {
            this.capacity += (this.capacity * 0.75);
            Contract[] arr = new Contract[this.capacity];

            this.copyArray(arr, this.contracts);
            this.contracts = arr;
        }

        contracts[this.nextCallIndex] = contact;
        nextCallIndex++;
    }
    public Contract[] getArray(){
        return contracts;
    }
    /**
     * Возвращает объект по его id
     *
     * @param id идентификатор объекта
     * @return Contact по идентификатору id
     *
     */


    public Contract searchByID(int id) {
        for (int i = 0; i < contracts.length; i++) {
            if (contracts[i].getID() == id) {
                return contracts[i];
            }
        }
        return null;
    }
    /**
     * Удаляет объект по его id
     *
     * @param id идентификатор объекта
     *
     */
    public void deleteByID(int id) {
        if (id <= nextCallIndex)
        {
            nextCallIndex--;
            for (int i = id - 1; i < nextCallIndex; i++)

            { contracts[i]=contracts[i+1];}

            contracts[nextCallIndex] = null;




        }
    }
    /**
     * копирует данные из одного массива в другой
     *
     * @param nextArray     новый массив
     * @param previousArray старый массив
     *
     */
    private void copyArray(Contract[] nextArray, Contract[] previousArray) {
        for (int i = 0; i < previousArray.length; i++) {
            nextArray[i] = previousArray[i];
        }

    }

    /**
     * Возвращает размер массива
     *
     * @return размер
     */
    public int size() {
        return this.nextCallIndex;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + capacity;
        result = prime * result + Arrays.hashCode(contracts);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Repository other = (Repository) obj;
        if (capacity != other.capacity)
            return false;
        if (!Arrays.equals(contracts, other.contracts))
            return false;
        return true;
    }
    public void sortBy(Comparator<Contract> comparator){
        sort.sort(contracts, comparator);
    }
    public void sortBy1(Comparator<Contract> comparator){
        sort1.sort(contracts, comparator);
    }

    public Repository searchBy(Predicate<Contract> predicate){
        Repository rep = new Repository();
        for (int i = 0; i < nextCallIndex; i++){
            if (predicate.test(contracts[i])){
                rep.add(contracts[i]);
            }
        }
        return rep;
    }
}





































