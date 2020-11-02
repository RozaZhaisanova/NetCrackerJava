package com.netcracker.classes.television;

import com.netcracker.classes.contract.Contract;
import com.netcracker.classes.person.Person;

import java.time.LocalDate;

/**
 * Контракт на цифровое телевидение
 */
public class Television extends Contract {
    /** Поле включенного в контракт пакета каналов */
    private ChannelPackage channelPackage;

    public Television(int id, LocalDate beginDate, LocalDate endDate, Person client, int number, ChannelPackage channelPackage) {
        super(id, beginDate, endDate, client, number);
        this.channelPackage=channelPackage;
    }

    public ChannelPackage getChannelPackage(){
        return channelPackage;
    }
    public void setChannelPackage(ChannelPackage channelPackage) {
        this.channelPackage = channelPackage;
    }

}
