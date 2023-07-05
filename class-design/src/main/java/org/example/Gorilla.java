package org.example;

public class Gorilla extends Animal {



    public Gorilla() {
        super(5);
    }

    public void checkTest() {
        Gorilla gorilla = new Gorilla();
        System.out.println(gorilla.getAge());
    }
}
