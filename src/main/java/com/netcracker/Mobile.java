package com.netcracker;

/**
 * Контракт на мобильную связь
 */
public class Mobile extends Contact {
    /** Поле включенных в контракт минут */
    private int min;
    /** Поле включенных в контракт мегабайт интернета */
    private int mb;
    /** Поле включенных в контракт смс */
    private int sms;
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
    public int mb(){
        return mb;
    }
    /**
     Устанавливает количество мегабайт
     @param mb
     количество мб
     */
    public void mb(int mb) {
        this.mb = mb;
    }
    /**
     Возвращает количество смс
     @return смс
     */
    public int sms(){
        return sms;
    }
    /**
     Устанавливает количество смс
     @param sms
     смс
     */
    public void sms(int sms) {
        this.sms = sms;
    }

}
