package com.netcracker.classes;

import com.netcracker.classes.contract.Contract;
import com.netcracker.classes.person.Person;
import com.netcracker.classes.repository.Repository;

import java.time.LocalDate;

public class App {
    public static void main(String[] args) {
        Contract c1 = new Contract(1, LocalDate.of(2019, 8, 3), LocalDate.of(2020, 5, 8), new Person(), 3);
        Contract c2 = new Contract(2, LocalDate.of(2008, 8, 18), LocalDate.of(2012, 3, 16), new Person(), 23);

        Repository rep = new Repository(4);
        rep.add(c1);
        rep.add(c2);

        System.out.println(rep.size());

    }
}