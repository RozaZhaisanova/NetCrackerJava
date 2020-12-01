package com.netcracker.validators;
import java.util.List;

/**
 * Абстрактный класс для проверки
 */
public abstract class Validator <T>{

  public abstract List<Result> validate(T t);

  public boolean validated(T t) {
        for (Result result : validate(t)) {
            if (result.getStatus() == Status.ERROR) {
                return false;
            }
        }
        return true;
    }
}