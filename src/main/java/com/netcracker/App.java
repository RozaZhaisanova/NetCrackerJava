package com.netcracker;

import com.netcracker.contract.Contract;
import com.netcracker.contract.Mobile;
import com.netcracker.enums.Gender;
import com.netcracker.person.Person;
import com.netcracker.repository.Csv;
import com.netcracker.repository.Repository;
import com.netcracker.validators.PersonValidator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class App {
    public static void main(String[] args) throws Exception{
        String csvFile = "src\\main\\resources\\contracts.csv";
        String line = "";
        String cvsSplitBy = ";";
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                String[]c = line.split(cvsSplitBy);
                System.out.println("др клиента[birthday = " + c[4]+ " , пол = " + c[5]+ " , паспорт =" + c[6]+ "]");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        Repository repo=new Repository();
        Repository rep= Csv.readAllDataFromCSV(csvFile,repo);
        System.out.println(" Имя клиента третьего в списке контракта:\n"+rep.getArray()[2].getClient());
        Person newPerson = new Person();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d.MM.yyyy");

        LocalDate beg = LocalDate.parse("2.12.1999", dtf);
        LocalDate end = LocalDate.parse("3.12.1999", dtf);
        Contract newContract2 = /*new Contract();
        newContract2 =*/ new Mobile(
               2, beg, end,
                newPerson, 21, 3, 32);
        rep.add(newContract2);
        System.out.println(" Айди контракта newContract2:\n"+ newContract2.getID());
        LocalDate date1 = LocalDate.parse("8.11.1999", dtf);
        Person person=new Person("Name", date1, Gender.MALE,"LO", 3542);
        PersonValidator personValidator = new PersonValidator();

      //  System.out.println(personValidator.validate(person).size());

    }}
