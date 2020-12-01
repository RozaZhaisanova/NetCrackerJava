package com.netcracker;

import com.netcracker.contract.Contract;
import com.netcracker.enums.Gender;
import com.netcracker.person.Person;
import com.netcracker.repository.Csv;

import com.netcracker.repository.Repository;
import com.netcracker.validators.ContractValidator;
import com.netcracker.validators.PersonValidator;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TestValidator{

    @Test
    public void testValidator()
    {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d.MM.yyyy");
        LocalDate date1 = LocalDate.parse("8.11.1999", dtf);
        Person person=new Person("Name", date1, Gender.MALE,"LOKP", 3542);
        PersonValidator personValidator = new PersonValidator();
        Contract c2 = new Contract(2, LocalDate.of(2008, 8, 18), LocalDate.of(2012, 3, 16), person, 323);
        ContractValidator contractValidator = new ContractValidator();
        Assert.assertEquals(contractValidator.validate(c2).size(),0);
        Assert.assertEquals(personValidator.validate(person).size(),0);
        Person person2=new Person("N", date1, Gender.MALE,"LOKP", 3542);//Некорректное имя
        Contract c3 = new Contract(2, LocalDate.of(2008, 8, 18), LocalDate.of(2012, 3, 16), person2, 323);
        Assert.assertEquals(contractValidator.validate(c3).size(),1);
        Assert.assertEquals(personValidator.validate(person2).size(),1);
    }
}
