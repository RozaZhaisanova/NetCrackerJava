package com.netcracker.classes.person;
/**
Класс паспорт пользователя со свойствми <b>series</b>, <b>number</b>
 */
public class Passport {
    /** Поле серия паспорта */
    private String series;
    /** Поле номер паспорта */
    private int number;

    /**
     * Конструктор с двумя параметрами
     * @param series
     *        серия паспорта
     * @param number
     *        номер паспорта
     */
    public Passport(String series, int number) {
        this.series = series;
        this.number = number;
    }

    public String getSeries() {
        return series;
    }

    public int getNumber() {
        return number;
    }
}