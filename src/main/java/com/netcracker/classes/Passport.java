package com.netcracker.classes;
/**
Класс паспорт пользователя со свойствми <b>series</b>, <b>number</b>
 */
public class Passport {
    /** Поле серия паспорта */
    private String series;
    /** Поле номер паспорта */
    private Integer number;

    /**
     * Конструктор с двумя параметрами
     * @param series
     *        серия паспорта
     * @param number
     *        номер паспорта
     */
    public Passport(String series, Integer number) {
        this.series = series;
        this.number = number;
    }

    public String getSeries() {
        return series;
    }

    public Integer getNumber() {
        return number;
    }
}