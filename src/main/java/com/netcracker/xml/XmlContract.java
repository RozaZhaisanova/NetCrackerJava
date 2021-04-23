package com.netcracker.xml;

import com.netcracker.enums.ChannelPackage;
import com.netcracker.person.Person;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;

/**
 * Класс для преобразования контрактов из xml
 */
public class XmlContract {

    @XmlElement
    public int id;

    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    public LocalDate beginDate;

    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    public LocalDate endDate;

    @XmlElement
    public Person person;

    @XmlElement
    public int mb;

    @XmlElement
    public int min;

    @XmlElement
    public int sms;

    @XmlElement
    public ChannelPackage channelPackage;

    @XmlElement
    public int maxSpeed;
}
