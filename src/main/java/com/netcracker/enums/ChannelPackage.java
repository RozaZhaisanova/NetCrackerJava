package com.netcracker.enums;
/**
 * Класс пакета каналов
 */


    public enum ChannelPackage {
        STANDARD("standard"),
        SPORT("sport"),
        FAMILY("family");
    private final String channelPackage;

    ChannelPackage(String channelPackage) {
        this.channelPackage = channelPackage;
    }

    public String getChannelPackage() {
        return channelPackage;
    }
    public static ChannelPackage fromString(String value) {
        if (value != null) {
            for (ChannelPackage cp : ChannelPackage.values()) {
                if (value.equalsIgnoreCase(cp.channelPackage)) {
                    return cp;
                }
            }
        }
        throw new IllegalArgumentException("No such value");
    }
    }

