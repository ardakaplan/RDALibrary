package com.ardakaplan.rdalibrarytest;

import com.ardakaplan.rdalibrary.base.objects.RDAObject;

/**
 * Created by Arda Kaplan on 14-Feb-19 - 15:57
 */
public class User extends RDAObject {

    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
