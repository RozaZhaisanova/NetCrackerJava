package com.netcracker.enums;

/**
 * Перечисление пол пользователя
 */
public enum Gender {
    MALE,
    FEMALE;
    /**
     * Возвращает пол, преобразует строку в Gender
     *  @param genderStr пол а форме строки
     *
     * @return пол Gender
     */
    public static Gender StringToGender(String genderStr)
    {
        if(genderStr.toLowerCase()=="male")
            return Gender.MALE;
        else return Gender.FEMALE;

    }
}
