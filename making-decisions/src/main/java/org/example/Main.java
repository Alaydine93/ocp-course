package org.example;

public class Main {
    public static void main(String[] args) {
        var hourOfDay = 19;
        var morningGreetingCount = 1;
        if (hourOfDay < 11)
            System.out.println("Good morning");
        else if(hourOfDay < 15)
            System.out.println("Good afternoon");
        else
            System.out.println("Good night");

        compareIntegers((Integer)12);
    }

    public static void compareIntegers(Number number){
        if(number instanceof final Integer data)
            System.out.println(data.compareTo(5));
    }
}