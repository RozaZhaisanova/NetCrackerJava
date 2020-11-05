package com.netcracker.classes;

import com.netcracker.classes.contract.Contract;
import com.netcracker.classes.person.Person;
import com.netcracker.classes.repository.Repository;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;

public class App {
    public static void main(String[] args) {
        Contract c1 = new Contract(1, LocalDate.of(2019, 8, 3), LocalDate.of(2020, 5, 8), new Person(), 3);
        Contract c2 = new Contract(2, LocalDate.of(2008, 8, 18), LocalDate.of(2012, 3, 16), new Person(), 23);
        Contract c3 = new Contract(2, LocalDate.of(2008, 8, 18), LocalDate.of(2012, 3, 16), new Person(), 23);

        Repository rep = new Repository(4);
        rep.add(c1);
        rep.add(c2);
        rep.add(c3);
        rep.sortBy(Contract.NumberComparator);
        System.out.println(rep.size());
        System.out.println(" Comparator по номеру:\n"+Arrays.toString(rep.getAllContracts()));


        Contract[] contracts = new Contract[4];
        contracts[0] = new Contract(1, LocalDate.of(2019, 8, 3), LocalDate.of(2020, 5, 8), new Person(), 3);
        contracts[1] = new Contract(9, LocalDate.of(2008, 8, 18), LocalDate.of(2012, 3, 16), new Person(), 23);
        contracts[2] = new Contract(6, LocalDate.of(2001, 8, 18), LocalDate.of(2022, 3, 16), new Person(), 213);
        contracts[3] = new Contract(2, LocalDate.of(2005, 8, 18), LocalDate.of(2032, 3, 16), new Person(), 13);
        // сортируем массив с помощью интерфейса Comparable
        Arrays.sort(contracts);
        System.out.println("Стандартная сортировка по id:\n"+ Arrays.toString(contracts));



        //сортируем массив с помощью интерфейса Comparator по возрасту
        Arrays.sort(contracts, Contract.NumberComparator);
        System.out.println("Comparator по номеру:\n"+Arrays.toString(contracts));

        // сортируем массив с помощью интерфейса Comparator по имени
        Arrays.sort(contracts, Contract.BeginDateComparator);
        System.out.println(" Comparator по дате начала контракта:\n"+Arrays.toString(contracts));




    }

   }
