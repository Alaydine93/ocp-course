package org.example.polymorphism;

public class Lemur extends Primate implements HasTail{

    @Override
    public boolean isTailStriped(){
        return false;
    }

    public int age = 10;
}
