package com.netcracker;
/**
Класс паспорт пользователя со свойствми <b>SERIES</b>, <b>NUMBER</b>
 */
public class Passport {
    /** Поле серия паспорта */
    final String SERIES;
    /** Поле номер паспорта */
    final Integer NUMBER;

    /**
     * Конструктор с двумя параметрами
     * @param series
     *        серия паспорта
     * @param number
     *        номер паспорта
     */
    public Passport(String series, Integer number) {
        this.SERIES = series;
        this.NUMBER = number;
    }

    public String getSeries() {
        return SERIES;
    }

    public Integer getNumber() {
        return NUMBER;
    }
}