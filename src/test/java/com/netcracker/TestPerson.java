package com.netcracker;

import com.netcracker.person.Person;
import com.netcracker.enums.Gender;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class TestPerson {

    @Test
    public void testGetDateOfBirth() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d.MM.yyyy");
        LocalDate date1 = LocalDate.parse("8.11.1999", dtf);
        Person person=new Person("Name1", date1, Gender.MALE,"LO", 3542);
        LocalDate date2=person.getDateOfBirth();
        Assert.assertEquals(date1, date2);
    }

    @Test
    public void testSetDateOfBirth() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d.MM.yyyy");
        LocalDate date1 = LocalDate.parse("8.11.1999", dtf);
        Person person=new Person();
        person.setDateOfBirth(date1);
        LocalDate date2=person.getDateOfBirth();
        Assert.assertEquals(date1, date2);
    }

    @Test
    public void testGetAge() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d.MM.yyyy");
        LocalDate date1 = LocalDate.parse("8.11.1999", dtf);
        Person person=new Person("Name1", date1, Gender.MALE,"LO", 3542);
        int age=person.getAge();
        Assert.assertEquals(age, 21);
    }



}

