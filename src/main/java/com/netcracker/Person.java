package com.netcracker;

import org.joda.time.*;

public class Person implements Comparable<Person> {
    /**
     * ID Пользователя
     */
    private int id;
    /**
     * Имя Пользователя
     */
    private String name;
    /**
     * Фамилия Пользователя
     */
    private String surname;
    /**
     * Дата рождения год/месяц/день
     */
    private LocalDate dateOfBirth;
    /**
     * Пол Пользователя
     */
    private Gender gender;
    /**
     * Паспорт Пользователя
     */
    private Passport passport;

    /**
     * Конструтор без параметров
     */
    public Person() {}

    /**
     * Конструтор с 6 параметрами
     * @param id
     *        id пользователя
     * @param name
     *        имя пользователя
     * @param surname
     *        фамилия пользователя
     * @param dateOfBirth
     *        Дата рождения
     * @param gender
     *        пол
     * @param passport
     *        номер, серия паспорта
     */
    public Person(int id, String name, String surname, LocalDate dateOfBirth,Gender gender,Passport passport) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.gender=gender;
        this.passport=passport;
    }

    /**
     * Конструтор с 4 параметрами
     * @param id
     *        id пользователя
     * @param name
     *        имя пользователя
     * @param surname
     *        фамилия пользователя
     * @param gender
     *        пол
     */
    public Person(int id, String name, String surname,Gender gender) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.gender=gender;
    }
    /**
     Возвращает ID данного пользователя
     @return ID пользователя
     */
    public int getID(){
        return id;
    }

    /**
     Устанавливает ID данного пользователя
     @param id
     id пользователя
     */
    public void setID(int id) {
        this.id = id;
    }

    /**
     Возвращает имя данного пользователя
     */
    public String getName() {
        return name;
    }
    /**
     Установливает имя данного пользователя
     @param name
     имя пользователя
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     Возвращает фамилия данного пользователя
     @return фамилия
     */
    public String getSurname() {
        return surname;
    }
    /**
     Устанавливает фамилия данного пользователя
     @param surname
     фамилия
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }
    /**
     Возвращает дату рождения данного пользователя
     @return Дату
     */
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     Устанавливает дату рождения данного пользователя
     @param dateOfBirth
     Дата рождения
     */
    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    /**
     Возвращает пол данного пользователя
     @return пол
     */
    public Gender getGender() {
        return this.gender;
    }
    /**
     Устанавливает пол данного пользователя
     @param gender
     Пол
     */
    public void setGender(Gender gender) {
        this.gender=gender;

    }
    /**
     Возвращает паспорт данного пользователя
     @return паспорт
     */
    public Passport getPassport() {
        return this.passport;
    }
    /**
     Устанавливает паспорт данного пользователя
     @param passport
     Пол
     */
    public void setPassport(Passport passport) {
        this.passport=passport;

    }
    /**
     Возвращает возраст пользователя
     return возраст
     */
    public int getAge()
    {
        LocalDate now=LocalDate.now();
        int year= now.minusYears(this.dateOfBirth.getYear()).getYear();
        if(now.getDayOfYear()<this.dateOfBirth.getDayOfYear())
            year--;
        return year;
    }

    public int compareTo(Person personY)
    {
        if(this.getAge()>personY.getAge())
            return 1;
        if(this.getAge()<personY.getAge())
            return -1;
        return 0;

    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((surname == null) ? 0 : surname.hashCode());
        result = prime * result + ((dateOfBirth == null) ? 0 : dateOfBirth.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Person other = (Person) obj;
        if (id != other.id)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (surname == null) {
            if (other.surname != null)
                return false;
        } else if (!surname.equals(other.surname))
            return false;
        if (dateOfBirth == null) {
            if (other.dateOfBirth != null)
                return false;
        } else if (!dateOfBirth.equals(other.dateOfBirth))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Hello, my name is "+ this.name;
    }








}
