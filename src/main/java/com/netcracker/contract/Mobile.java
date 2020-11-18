package com.netcracker.contract;

import com.netcracker.person.Person;

import java.time.LocalDate;

/**
 * Контракт на мобильную связь
 */
public class Mobile extends Contract {
    /** Поле включенных в контракт минут */
    private int min;
    /** Поле включенных в контракт мегабайт интернета */
    private int mb;
    /** Поле включенных в контракт смс */
    private int sms;

    public Mobile(int id, LocalDate beginDate, LocalDate endDate, Person client, int number, int min, int mb, int sms) {
        super(id, beginDate, endDate, client, number);
        this.min=min;
        this.mb=mb;
        this.sms=sms;

    }

    public Mobile() {

    }

    public Mobile(int id, LocalDate beginDate, LocalDate endDate, Person client, int min, int mb, int sms) {
        this.id=id;
        this.beginDate=beginDate;
        this.endDate=endDate; this.client=client;
       this.min=min;
        this.mb=mb;
        this.sms=sms;
    }

    /**
     Возвращает количество минут
     @return минут
     */
    public int getMin(){
        return min;
    }
    /**
     Устанавливает количество минут
     @param min
     количество минут
     */
    public void setMin(int min) {
        this.min = min;
    }
    /**
     Возвращает количество мегабайт
     @return мб
     */
    public int getMb(){
        return mb;
    }
    /**
     Устанавливает количество мегабайт
     @param mb
     количество мб
     */
    public void setMb(int mb) {
        this.mb = mb;
    }
    /**
     Возвращает количество смс
     @return смс
     */
    public int getSms(){
        return sms;
    }
    /**
     Устанавливает количество смс
     @param sms
     смс
     */
    public void setSms(int sms) {
        this.sms = sms;
    }

}
