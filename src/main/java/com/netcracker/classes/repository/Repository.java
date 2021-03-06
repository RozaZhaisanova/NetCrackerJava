package com.netcracker.classes.repository;

import com.netcracker.classes.contract.Contract;

import java.util.Arrays;

public class Repository {
    /**
     * массив контактов
     */
    private Contract[] contacts;
    /**
     * ёмкость массива
     */
    private int capacity = 16;

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
        this.contacts = new Contract[capacity];
    }

    /**
     * Конструктор с 1 параметром
     *
     * @param capacity начальная длина массива
     *
     */
    public Repository(int capacity) {
        this.capacity = capacity;
        this.contacts = new Contract[capacity];
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

            this.copyArray(arr, this.contacts);
            this.contacts = arr;
        }

        contacts[this.nextCallIndex] = contact;
        nextCallIndex++;
    }

    /**
     * Возвращает объект по его id
     *
     * @param id идентификатор объекта
     * @return Contact по идентификатору id
     *
     */


    public Contract searchByID(int id) {
        for (int i = 0; i < contacts.length; i++) {
            if (contacts[i].getID() == id) {
                return contacts[i];
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

            { contacts[i]=contacts[i+1];}

            contacts[nextCallIndex] = null;




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
        result = prime * result + Arrays.hashCode(contacts);
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
        if (!Arrays.equals(contacts, other.contacts))
            return false;
        return true;
    }

}


