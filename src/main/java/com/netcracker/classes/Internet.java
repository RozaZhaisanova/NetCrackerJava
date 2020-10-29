package com.netcracker.classes;

import java.time.LocalDate;

/**
 * Контракт на проводной интернет
 */
public class Internet extends Contract {
    /** Поле поддерживаемой максимальной скорости */
    private int maxSpeed;

    public Internet(int id, LocalDate beginDate, LocalDate endDate, Person client, int number) {
        super(id, beginDate, endDate, client, number);
    }

    /**
     Возвращает максимальную скорость
     @return скорость
     */
    public int getMaxSpeed(){
        return maxSpeed;
    }
    /**
     Устанавливает максимальную скорость
     @param maxSpeed
     фамилия
     */
    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

}
