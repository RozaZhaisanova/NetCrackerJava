package com.netcracker;

/**
 * Контракт на цифровое телевидение
 */
public class Television extends Contact {
    /** Поле включенного в контракт пакета каналов */
    private ChannelPackage channelPackage;
    public ChannelPackage getChannelPackage(){
        return channelPackage;
    }
    public void setChannelPackage(ChannelPackage channelPackage) {
        this.channelPackage = channelPackage;
    }

}
