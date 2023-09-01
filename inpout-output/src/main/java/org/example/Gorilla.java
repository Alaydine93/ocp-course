package org.example;

import java.io.Serializable;

public class Gorilla implements Serializable {
    public Gorilla(String name, int age, Boolean friendly) {
        this.name = name;
        this.age = age;
        this.friendly = friendly;
    }

    private static final long serialVersionUID = 1l;
    private String name;
    private int age;
    private Boolean friendly;
    private transient String favoriteFood;
}
