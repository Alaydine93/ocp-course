package org.example;

public class Duck implements Comparable<Duck> {

    private String name;

    private int weight;

    public Duck(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public String toString() {
        return name;
    }

    @Override
    public int compareTo(Duck duck) {
        if (duck == null)
            throw new IllegalArgumentException("Poorly formed duck");
        if (this.name == null && duck.name == null)
            return 0;
        else if (this.name == null)
            return -1;
        else if (duck.name == null)
            return 1;
        else return name.compareTo(duck.name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
