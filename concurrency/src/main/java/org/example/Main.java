package org.example;

public class Main {
    public static void main(String[] args) {

    }

    private static void printWithRunnable() {
        Runnable printInventory = () -> System.out.println("Printing zoo inventory");
        Runnable printRecords = () -> {
            for(int i = 0; i < 3; i++){
                System.out.println("Printing record : " + i);
            }
        };
        System.out.println("Begin");
        new Thread(printInventory).start();
        new Thread(printRecords).start();

        new Thread(printInventory).start();
        System.out.println("End");
    }
}