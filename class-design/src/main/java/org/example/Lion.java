package org.example;

public class Lion extends Animal {
    private int weight;
    private String color;

    public Lion() {
    }

    public Lion(int weight, String color) {
        this.weight = weight;
        this.color = color;
    }

    public Lion(int weight) {
        this(weight, "brown");
    }

    protected void setProperties(int age, String n) {
        setAge(age);
        name = n;
    }

    public void roar() {
        System.out.println(name + ", age " + getAge() + ", says: Roar!");
    }
}
