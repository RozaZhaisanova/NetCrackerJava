package com.netcracker.classes;

import java.time.LocalDate;

public class Contract {
    /**
     * ID контракта
     */
    private int id;
    /**
     * Дата начала контракта год/месяц/день
     */
    private LocalDate beginDate;
    /**
     * Дата конца контракта год/месяц/день
     */
    private LocalDate endDate;
    /**
     * Клиент
     */
    Person client;
    /**
     * Номер контракта
     */
    private int number;

    /**
     Устанавливает дату начала контракта
     @param beginDate
     дата начала контракта
     */
    public void setBeginDate(LocalDate beginDate) {
        this.beginDate = beginDate;
    }
    /**
     Устанавливает дату конца контракта
     @param endDate
     дата конца контракта
     */
    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
    /**
     Возвращает дату начала контракта
     @return Дату
     */
    public LocalDate getBeginDate() {
        return beginDate;
    }
    /**
     Возвращает дату конца контракта
     @return Дату
     */
    public LocalDate getEndDate() {
        return endDate;
    }
    /**
     Устанавливает ID контракта
     @param id
     id контракта
     */
    public void setID(int id) {
        this.id = id;
    }
    /**
     Возвращает ID контракта
     @return ID контракта
     */
    public  int getID(){
        return id;
    }
    /**
     Устанавливает number контракта
     @param number
     номер контракта
     */
    public void setNumber(int number) {
        this.number = number;
    }
    /**
     Возвращает номер контракта
     @return number контракта
     */
    public  int getNumber(){
        return number;
    }
    /**
     Устанавливает клиента
     @param client
     дата конца контракта
     */
    public void setClient(Person client) {
        this.client = client;
    }
    /**
     Возвращает клиента
     @return client
     */
    public Person getClient() {
        return client;
    }
    public Contract(int id, LocalDate beginDate, LocalDate endDate,Person client,int number) {
        this.id = id;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.client=client;
        this.number=number;

    }
    public Contract(int id, int number) {
        this.id = id;

        this.number=number;

    }
    @Override
    public String toString() {
        return "Contract`s number "+ this.number;
    }
}
