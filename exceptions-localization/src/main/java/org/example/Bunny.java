package org.example;

import exceptions.NoMoreCarrotsException;

public class Bunny {

    public static void main(String[] args) {
        try {
            eatCarrot();
        } catch (NoMoreCarrotsException e) {
            System.out.println("sad rabbit");
        }
    }

    private static void eatCarrot() throws NoMoreCarrotsException  {
        return;
    }
}
