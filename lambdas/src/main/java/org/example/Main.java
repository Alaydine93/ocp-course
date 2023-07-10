package org.example;

import org.example.interfaces.CheckTrait;
import org.example.records.Animal;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        var animals = new ArrayList<Animal>();
        animals.add(new Animal("fish", false, true));
        animals.add(new Animal("kangaroo", true, false));
        animals.add(new Animal("rabbit", true, false));
        animals.add(new Animal("turtle", false, true));

        print(animals, a -> a.canSwim());
        print(animals, Animal::canHop);

        CheckTrait trait = Animal::canHop;

        testConsumer();

    }

    private static void print(List<Animal> animals, CheckTrait checker){
        for(Animal animal : animals){
            if(checker.test(animal)){
                System.out.print(animal + " ");
                System.out.println();
            }
        }
        System.out.println();
    }

    private static void testSuppliers(){
        Supplier<LocalDate> sp1 = LocalDate::now;
        Supplier<LocalDate> sp2 = () -> LocalDate.now();

        LocalDate ld1 = sp1.get();
        LocalDate ld2 = sp2.get();
    }

    private static void testConsumer(){
        Consumer<String> cs1 = System.out::println;
        cs1.accept("toto");
    }
}