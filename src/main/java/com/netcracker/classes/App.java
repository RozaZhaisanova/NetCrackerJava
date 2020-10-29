package com.netcracker.classes;

import java.time.LocalDate;

public class App {
    public static void main(String[] args) {
        Contract c1 = new Contract(1, LocalDate.of(2019, 8, 3), LocalDate.of(2020, 5, 8), new Person(), 3);
        Contract c2 = new Contract(2, LocalDate.of(2008, 8, 18), LocalDate.of(2012, 3, 16), new Person(), 23);

        Repository pr = new Repository(4);
        pr.add(c1);
        pr.add(c2);

        System.out.println(pr.size());

    }
}