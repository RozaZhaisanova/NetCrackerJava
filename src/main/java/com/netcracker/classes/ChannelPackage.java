package com.netcracker.classes;
/**
 * Класс пакета каналов со свойствми <b>name</b>, <b>numberOfChannels</b>, <b>channels</b>
 */
public class ChannelPackage {
    /** Поле имени пакета */
    private String name;
    /** Поле количество каналов в пакете */
    private int numberOfChannels;
    /** Поле массив каналов */
    private String[] channels;
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }


}
