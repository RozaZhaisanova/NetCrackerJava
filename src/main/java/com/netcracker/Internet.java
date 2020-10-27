package com.netcracker;

/**
 * Контракт на проводной интернет
 */
public class Internet extends Contact {
    /** Поле поддерживаемой максимальной скорости */
    private int maxSpeed;
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
