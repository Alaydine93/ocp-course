package org.example;

public class Main {
    public static void main(String[] args) {
        var immutableAnimal = new ImmutableAnimal();
        for (int i = 0; i < immutableAnimal.getFavoriteFoodCount(); i++) {
            System.out.println(immutableAnimal.getFavoriteFoodItem(i));
        }
    }
}