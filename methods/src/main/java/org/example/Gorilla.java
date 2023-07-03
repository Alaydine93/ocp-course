package org.example;

public class Gorilla {

    static final int bamboo;
    static {bamboo = 3;}

    public static int count;

    public static void addGorilla() {
        count++;
    }

    public void babyGorilla() {
        count++;
        int bad = (int)8l;
    }

    public void announceBabies() {
        addGorilla();
        babyGorilla();
    }

    public static void announceBabiesToEveryOne() {
        addGorilla();
        var gorilla = new Gorilla();
        gorilla.babyGorilla();
        gorilla.announceBabies();
        System.out.println("number of babies %s".formatted(count));
    }
}
