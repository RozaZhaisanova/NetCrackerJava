package com.netcracker;

import com.netcracker.contract.Contract;
import com.netcracker.person.Person;
import com.netcracker.repository.Csv;

import com.netcracker.repository.Repository;
import org.junit.Assert;
import org.junit.Test;

public class TestReader{

    @Test
    public void testCSV()
    {
        String csvFile = "src\\main\\resources\\contracts.csv";
        Repository repo=new Repository();
        Repository rep= Csv.readAllDataFromCSV(csvFile,repo);
        Contract c=rep.getArray()[0];
        Assert.assertEquals(834, c.getID());
        Person p=rep.getArray()[0].getClient();
        Assert.assertEquals("ivan", p.getName());
        //Assert.assertEquals(65, c.getMaxSpeed());

    }
}
