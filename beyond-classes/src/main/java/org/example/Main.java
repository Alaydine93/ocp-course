package org.example;


import org.example.nested.Fox;
import org.example.nested.Home;
import org.example.nested.PrintNumbers;
import org.example.polymorphism.HasTail;
import org.example.polymorphism.Lemur;
import org.example.polymorphism.Primate;
import org.example.records.Crane;

public class Main {
    public static void main(String[] args) {
        testPolymorphism();
    }

    public static void testPolymorphism(){
        Lemur lemur = new Lemur();
        System.out.println(lemur.age);

        HasTail tail = lemur;
        System.out.println(tail.isTailStriped());

        Primate primate = lemur;
        System.out.println(primate.hasHair());

        //This one throws ClassCastException at runtime
        Primate primate1 = new Primate();
        Lemur lemur1 = (Lemur)primate1;
        System.out.println(lemur1.age);
    }

    private static void useNestedClasses() {
        new Home().new Room().enter();
    }

    private static void useRecords() {
        var father = new Crane(0, "Alae");
        System.out.println(father);

        var copy = new Crane(0, "Alae");
        System.out.println(copy);

        var customConstructCall = new Crane("Alae", "Rachidi");
        System.out.println(customConstructCall);
        System.out.println(customConstructCall.numberEggs());

        System.out.println(father.equals(copy));
        System.out.println(father.hashCode() + " " + copy.hashCode());
    }
}