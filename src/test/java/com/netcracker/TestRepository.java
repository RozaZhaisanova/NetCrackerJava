package com.netcracker;

import com.netcracker.classes.Contract;
import com.netcracker.classes.Repository;
import org.junit.*;

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
    public void testAddIPerson() {
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

   /* @Test
    public void testAddIPerson2()
    {
        Person px=new Person(111,"Namex");
        Person p3=(Person)myRepository.get(2);
        myRepository.add(2,px);
        Assert.assertEquals(px,myRepository.get(2));
        Assert.assertEquals(p3,myRepository.get(3));
    }*/

    @Test
    public void TestGetSize()
    {
        int res=myRepository.size();
        Assert.assertEquals(res,9);
    }



}
