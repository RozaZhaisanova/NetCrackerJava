package com.netcracker.contract;

import com.netcracker.person.Person;
import com.netcracker.enums.ChannelPackage;

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

    public Television() {

    }

    public Television(int id, LocalDate beginDate, LocalDate endDate, Person client, ChannelPackage channelPackage) {
        this.id=id;
        this.beginDate=beginDate;
        this.endDate=endDate;
        this.client=client;
        this.channelPackage=channelPackage;

    }

    public ChannelPackage getChannelPackage(){
        return channelPackage;
    }
    public void setChannelPackage(ChannelPackage channelPackage) {
        this.channelPackage = channelPackage;
    }

}
