package org.example.services;

import org.example.helpers.DuckHelper;

public class Duckling {

    public static void makeSound(String sound){
        DuckHelper.teacher(sound, System.out::println);
    }
}
