package org.example;

import Utils.DateFormatter;
import Utils.NumberFormatter;
import ressources.JammedTurkeyCage;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        NumberFormatter.numberToCurrency();

        DateFormatter.formatDate();
        System.out.println();

        NumberFormatter.formatNumbers();
        System.out.println();

        try (JammedTurkeyCage cage = new JammedTurkeyCage()) {
            System.out.println("Put turkeys in cage");
        } catch (IllegalStateException e) {
            System.out.println("Caught " + e.getMessage());
        }
        System.out.println();
        try {
            System.out.println(args[1]);
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
            System.out.println("Missing or invalid input");
        }
        System.out.println();
        try {
            FileReader.readFile();
        } catch (IOException e) {
        }
    }

    void fall(int distance) throws IOException {
        if (distance < 10)
            throw new IOException();
    }

    void fallHandled(int distance) {
        try {
            if (distance < 10)
                throw new IOException();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}