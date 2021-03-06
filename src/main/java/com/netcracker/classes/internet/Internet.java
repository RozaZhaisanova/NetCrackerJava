package com.netcracker.classes.internet;

import com.netcracker.classes.contract.Contract;
import com.netcracker.classes.person.Person;

import java.time.LocalDate;

/**
 * Контракт на проводной интернет
 */
public class Internet extends Contract {
    /** Поле поддерживаемой максимальной скорости */
    private int maxSpeed;

    public Internet(int id, LocalDate beginDate, LocalDate endDate, Person client, int number, int maxSpeed) {
        super(id, beginDate, endDate, client, number);
        this.maxSpeed=maxSpeed;
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
