package org.example;

public class Main {
    public static void main(String[] args) {
        Integer intNumber = 3;
        double number = 1;
        openZoo(intNumber);
        openZoo(null);

        int owl = 1;
        int food1 = owl < 4 ? owl > 2 ? 3 : 4 : 5;
        System.out.println("ternary result : " + food1);

        var stripes = 11;

        var animal = stripes < 9 ? 3 : "Horse";
        int toto = 2*(int)3;

        System.out.println(animal);
    }

    public static void openZoo(Number time) {
        if (time instanceof Integer)
            System.out.println((Integer) time + " O'clock");
        else
            System.out.println(time);
    }
}