package com.netcracker;

import com.netcracker.classes.person.Passport;
import com.netcracker.classes.person.Person;
import com.netcracker.enums.Gender;
import org.joda.time.LocalDate;
import org.junit.Assert;
import org.junit.Test;


public class TestPerson {

    @Test
    public void testGetDateOfBirth() {
        LocalDate date1=new LocalDate(1999,11,8);
        Person person=new Person(1,"Name1","Surname1", date1, Gender.MALE,new Passport("LO", 3542));
        LocalDate date2=person.getDateOfBirth();
        Assert.assertEquals(date1, date2);
    }

    @Test
    public void testSetDateOfBirth() {
        LocalDate date1=new LocalDate(1999,11,8);
        Person person=new Person();
        person.setDateOfBirth(date1);
        LocalDate date2=person.getDateOfBirth();
        Assert.assertEquals(date1, date2);
    }

    @Test
    public void testGetAge() {
        LocalDate date1=new LocalDate(1999,11,8);
        Person person=new Person(1,"Name1","Surname1",date1,Gender.MALE,new Passport("LO", 3542));
        int age=person.getAge();
        Assert.assertEquals(age, 20);
    }



}

