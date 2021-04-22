package com.netcracker;

import com.netcracker.contract.Contract;
import com.netcracker.contract.Internet;
import com.netcracker.contract.Mobile;
import com.netcracker.contract.Television;
import com.netcracker.db.DatabaseParser;
import com.netcracker.db.IDatabaseParser;
import com.netcracker.enums.ChannelPackage;
import com.netcracker.person.Person;

import java.sql.SQLException;
import java.time.LocalDate;

public class App {
    public static void main(String[] args) throws Exception{

        Person p1 = new Person(1,"nam1","surnam1",LocalDate.of(1999, 8, 3));
        Person p2 = new Person(2,"nam2","surnam2",LocalDate.of(1999, 8, 13));
        Contract c1 = new Internet(1, LocalDate.of(2019, 8, 3), LocalDate.of(2020, 5, 8), p1, 4,3);
        Contract c2 = new Mobile(2, LocalDate.of(2008, 8, 18), LocalDate.of(2012, 3, 16), p1, 23,3333,10000,400);
        Contract c3 = new Television(8, LocalDate.of(2009, 8, 18), LocalDate.of(2012, 3, 16), p2, 27, ChannelPackage.SPORT);


        IDatabaseParser dbReader = new DatabaseParser();
        dbReader.savePerson(p1);
        dbReader.savePerson(p2);
        dbReader.saveContract(c1);
        dbReader.saveContract(c2);
        dbReader.saveContract(c3);

        try {
            dbReader.getAllClients();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            dbReader.getAllContracts();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
