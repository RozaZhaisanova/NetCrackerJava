package com.netcracker;
/**
 * Класс пакета каналов со свойствми <b>name</b>, <b>numberOfChannels</b>, <b>channels</b>
 */
public class ChannelPackage {
    /** Поле имени пакета */
    String name;
    /** Поле количество каналов в пакете */
    int numberOfChannels;
    /** Поле массив пакетов */
    String[] channels;
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }


}
