package com.bigdata.redjoin;

/**
 * Created by jose.rozanec
 */
public class Person {
    private String id;
    private String name;
    private String surname;
    private String sex;
    private int bornYYYY;
    private String zip;

    public Person(String id, String name, String surname, String sex, int bornYYYY, String zip) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.sex = sex;
        this.bornYYYY = bornYYYY;
        this.zip = zip;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getSex() {
        return sex;
    }

    public int getBornYYYY() {
        return bornYYYY;
    }

    public String getZip() {
        return zip;
    }
}
