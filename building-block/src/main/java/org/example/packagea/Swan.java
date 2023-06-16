package org.example.packagea;

public class Swan {

    int numberEggs;

    public static void main(String[] args) {
        Swan mother = new Swan();
        mother.numberEggs = 777;
        System.out.println(mother.numberEggs);
    }
}
