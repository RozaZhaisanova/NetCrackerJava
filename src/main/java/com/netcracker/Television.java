package com.netcracker;

import java.time.LocalDate;

/**
 * Контракт на цифровое телевидение
 */
public class Television extends Contract {
    /** Поле включенного в контракт пакета каналов */
    private ChannelPackage channelPackage;

    public Television(int id, LocalDate beginDate, LocalDate endDate, Person client, int number) {
        super(id, beginDate, endDate, client, number);
    }

    public ChannelPackage getChannelPackage(){
        return channelPackage;
    }
    public void setChannelPackage(ChannelPackage channelPackage) {
        this.channelPackage = channelPackage;
    }

}
