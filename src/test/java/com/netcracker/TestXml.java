package com.netcracker;

import com.netcracker.contract.Internet;
import com.netcracker.contract.Mobile;
import com.netcracker.contract.Television;
import com.netcracker.enums.ChannelPackage;
import com.netcracker.enums.Gender;
import com.netcracker.person.Person;
import com.netcracker.repository.Repository;
import com.netcracker.xml.XmlParser;
import org.junit.Test;

import javax.xml.bind.JAXBException;
import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class TestXml {

    @Test
    public void restore() {
        try {
            XmlParser xmlParser = new XmlParser();
            Repository rep1 = new Repository();
            rep1.add(new Internet(
                    1,
                    LocalDate.of(2010, 10, 12),
                    LocalDate.of(2016, 3, 22),
                    new Person(0, "name1", "surname1", LocalDate.of(1999, 3, 12), Gender.MALE),500
            ));
            rep1.add(new Mobile(
                    2,
                    LocalDate.of(2011, 11, 2),
                    LocalDate.of(2017, 3, 8),
                    new Person(1, "name2", "surname2", LocalDate.of(1999, 3, 10), Gender.MALE),
                    300,
                    1000,
                    400
            ));
            rep1.add(new Television(
                    3,
                    LocalDate.of(2005, 1, 4),
                    LocalDate.of(2006, 3, 5),
                    new Person(2, "name3", "surname3", LocalDate.of(2000, 1, 2), Gender.FEMALE), ChannelPackage.FAMILY
            ));

            xmlParser.save(rep1);
            Repository rep2 = xmlParser.restore();
            assertEquals(rep2.size(), rep1.size());
        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }
}