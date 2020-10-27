package com.netcracker;

import java.time.LocalDate;

public class Contact {
    /**
     * ID контакта
     */
    private int id;
    /**
     * Дата начала контакта год/месяц/день
     */
    private LocalDate beginDate;
    /**
     * Дата конца контакта год/месяц/день
     */
    private LocalDate endDate;
    /**
     * Клиент
     */
    Person client;

    /**
     Устанавливает дату начала контракта
     @return Дату
     */
    public LocalDate getBeginDate() {
        return beginDate;
    }
    /**
     Устанавливает дату конца контракта
     @return Дату
     */
    public LocalDate getEndDate() {
        return endDate;
    }
    /**
     Возвращает ID контакта
     @return ID контакта
     */
    public  int getID(){
        return id;
    }
}
