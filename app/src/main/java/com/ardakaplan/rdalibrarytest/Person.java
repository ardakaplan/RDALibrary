package com.ardakaplan.rdalibrarytest;

import com.ardakaplan.rdalibrary.objects.RDAObject;

/**
 * Created by Arda Kaplan on 10.08.2018 - 17:43
 */
public class Person extends RDAObject {

    private String name;
    private String surname;


    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
