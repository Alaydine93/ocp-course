package org.example;

import Utils.DateFormatter;
import Utils.NumberFormatter;
import ressources.JammedTurkeyCage;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import static java.time.format.FormatStyle.SHORT;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(new Locale("en", "US"));
        var italy = new Locale("it", "IT");
        var dt = LocalDateTime.of(2022, Month.DECEMBER, 20, 15, 12, 34);
        DateFormatter.print(DateTimeFormatter.ofLocalizedDate(SHORT), dt, italy);

    }

    private static void suppressedExceptions() {
        try (var t = new JammedTurkeyCage()){
            throw new IllegalStateException("Turkey ran off");
        } catch (IllegalStateException e) {
            System.out.println("Caught : " + e.getMessage());
            for(Throwable t : e.getSuppressed()){
                System.out.println("Suppressed : " + t.getMessage());
            }
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