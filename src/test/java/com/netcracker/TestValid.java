package com.netcracker;

import com.netcracker.contract.Contract;
import com.netcracker.enums.Gender;
import com.netcracker.person.Person;
import com.netcracker.validators.ContractValidator;
import com.netcracker.validators.PersonValidator;
import com.netcracker.validators.Validator;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TestValid {
    @Test
    public void testValid() {
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d.MM.yyyy");
    LocalDate date1 = LocalDate.parse("8.11.1999", dtf);
    Person person=new Person("Name1", date1, Gender.MALE,"LO", 3542);
    Person person3=new Person("Name1", date1, Gender.MALE,"LO", 3542);
    Contract c1 = new Contract(11, LocalDate.of(2019, 8, 3), LocalDate.of(2020, 5, 8), person, 223);
    Contract c2 = new Contract(8, LocalDate.of(2009, 8, 18), LocalDate.of(2009, 8, 18), person3, 27);
    Validator[] validators3 = new Validator[2];
    validators3[0] = new PersonValidator();
    validators3[1] = new ContractValidator();
    Validator.validation(validators3, c1);
    Validator.validation(validators3, c2);
    Validator v=new ContractValidator().validator(c1);
    Validator v2=new ContractValidator().validator(c2);
    Validator v1=new PersonValidator().validator(c1);
    Assert.assertEquals(  v.getStatus(),"successful" );
    Assert.assertEquals(  v2.getStatus(),"warning" );
    Assert.assertEquals(  v1.getStatus(),"warning" );
}}
