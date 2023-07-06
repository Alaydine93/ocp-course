package org.example;

public class MantaRay {
    private String name = "Sammy";

    public static void first() {
    }

    public static void second() {
    }

    public void third() {
        System.out.println(name);
    }

    public static void main(String[] args) {
        first();
        second();
        var mantaRay = new MantaRay();
        mantaRay.third();

        Gorilla.announceBabiesToEveryOne();
    }
}