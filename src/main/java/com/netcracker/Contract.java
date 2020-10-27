package com.netcracker;

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
     @return Дату
     */
    private LocalDate getBeginDate() {
        return beginDate;
    }
    /**
     Устанавливает дату конца контракта
     @return Дату
     */
    private LocalDate getEndDate() {
        return endDate;
    }
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
    public Contract(int id, LocalDate beginDate, LocalDate endDate,Person client,int number) {
        this.id = id;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.client=client;
        this.number=number;

    }
    @Override
    public String toString() {
        return "Hello My Name Is"+ this.number;
    }
}
