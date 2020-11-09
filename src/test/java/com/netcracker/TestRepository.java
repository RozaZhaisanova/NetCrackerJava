package com.netcracker;

import com.netcracker.classes.contract.Contract;
import com.netcracker.classes.person.Passport;
import com.netcracker.classes.person.Person;
import com.netcracker.classes.repository.Predicates;
import com.netcracker.classes.repository.Repository;
import com.netcracker.enums.Gender;
import org.junit.*;

import java.time.LocalDate;

import static org.junit.Assert.assertArrayEquals;

public class TestRepository {
    private static Repository myRepository;

    @Before
    public void BeforeMethod()
    {
        Contract p1=new Contract(1,12);
        Contract p2=new Contract(2,18);
        Contract p3=new Contract(3,3);
        Contract p4=new Contract(4,15);
        Contract p5=new Contract(5,21);
        Contract p6=new Contract(6,65);
        Contract p7=new Contract(7,5);
        Contract p8=new Contract(8,78);
        Contract p9=new Contract(9,90);
        Repository r=new Repository();
        r.add(p1);
        r.add(p2);
        r.add(p3);
        r.add(p4);
        r.add(p5);
        r.add(p6);
        r.add(p7);
        r.add(p8);
        r.add(p9);
        myRepository=r;
    }
    @Test
    public void testSortBy() {
        Contract c1 = new Contract(1, LocalDate.of(2019, 8, 3), LocalDate.of(2020, 5, 8), new Person(), 223);
        Contract c2 = new Contract(2, LocalDate.of(2008, 8, 18), LocalDate.of(2012, 3, 16), new Person(), 323);
        Contract c3 = new Contract(8, LocalDate.of(2009, 8, 18), LocalDate.of(2012, 3, 16), new Person(), 27);
        Repository rep = new Repository(3);
        rep.add(c1);
        rep.add(c2);
        rep.add(c3);
        rep.sortBy1(Contract.BeginDateComparator);
        Contract[] arr = new Contract[rep.getArray().length];
        arr[0] = c2;
        arr[1] = c3;
        arr[2] = c1;
        assertArrayEquals(rep.getArray(), arr);
    }

    @Test
    public void testSearchBy() {
        Contract c1 = new Contract(1, LocalDate.of(2019, 8, 3), LocalDate.of(2020, 5, 8), new Person(), 3);
        Contract c2 = new Contract(2, LocalDate.of(2008, 8, 18), LocalDate.of(2012, 3, 16), new Person(), 23);
        Contract c3 = new Contract(8, LocalDate.of(2009, 8, 18), LocalDate.of(2012, 3, 16), new Person(), 27);
        Repository rep = new Repository(3);
        rep.add(c1);
        rep.add(c2);
        rep.add(c3);
        org.joda.time.LocalDate date1=new org.joda.time.LocalDate(1999,11,8);
        Person person=new Person(1,"Name1","Surname1", date1, Gender.MALE,new Passport("LO", 3542));
        Predicates pred = new Predicates();
        Repository newRep = rep.searchBy(pred.clientPredicate(person));
        assertArrayEquals(newRep.getArray(), rep.searchBy(pred.clientPredicate(person)).getArray());
    }
    @Test
    public void testAdd() {
        int size=myRepository.size();
        Assert.assertEquals(size,9);
    }

    @Test
    public void testSearchByID()
    {
        Contract p10=new Contract(10,10);
        myRepository.add(p10);
        Contract px=myRepository.searchByID(10);
        Assert.assertEquals(px,p10);
    }

    @Test
    public void testDelete() {
        myRepository.deleteByID(2);
        Assert.assertEquals(8, myRepository.size());
    }

    @Test
    public void TestGetSize()
    {
        int res=myRepository.size();
        Assert.assertEquals(res,9);
    }



}