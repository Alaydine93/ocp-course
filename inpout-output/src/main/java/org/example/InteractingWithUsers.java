package org.example;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.Console;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UncheckedIOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;

public class InteractingWithUsers {

    public static void main(String... args) throws IOException {
        var size = getPathSize(Path.of("/Users/alae-eddine/Dev"));
        System.out.format("Total Size: %.2f megabytes", (size / 1_000_000.0));
        System.out.print(System.lineSeparator() + System.lineSeparator());
        byte[] byteArray = {'L', 'I', 'O', 'N'};
        readData(new BufferedInputStream(new ByteArrayInputStream(byteArray)));
    }

    public static long getPathSize(Path source) throws IOException {
        try (var s = Files.walk(source, FileVisitOption.FOLLOW_LINKS)) {
            return s.parallel()
                    .filter(p -> !Files.isDirectory(p))
                    .mapToLong(x -> getSize(x))
                    .sum();
        }
    }

    private static long getSize(Path p) {
        try {
            return Files.size(p);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    public static void readData(InputStream is) throws IOException {
        System.out.println((char) is.read());
        if (is.markSupported()) {
            is.mark(100);
            System.out.println((char) is.read());
            System.out.println((char) is.read());
            is.reset();
        }
        System.out.println((char) is.read());
        System.out.println((char) is.read());
        System.out.println((char) is.read());
    }

    static void printFormattedMessages() {
        Console console = System.console();
        if (console == null) {
            throw new RuntimeException("Console not available");
        } else {
            console.writer().println("Welcome to ou zoo!");
            console.format("It has %d animals and employs %d people", 391, 25);
            console.writer().println();
            console.printf("The zoo spans %5.1f acred", 128.97);
        }
    }

    static void readFromUserUsingConsole() {
        Console console = System.console();
        if (console == null) {
            String userInput = console.readLine();
            console.writer().println("You entered: " + userInput);
        } else {
            System.err.println("Console not available");
        }
    }

    static void readFromUser() throws IOException {
        var reader = new BufferedReader(new InputStreamReader(System.in));
        String userInput = reader.readLine();
        System.out.println("You entered : " + userInput);
    }
}
