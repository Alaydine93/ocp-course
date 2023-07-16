package org.example;

import ressources.MyFileClass;

import java.io.IOException;

public class FileReader {

    public static void readFile() throws IOException {
        final var myFile1 = new MyFileClass(1);
        try (myFile1; var myFile2 = new MyFileClass(2)) {
            System.out.println("try block");
            throw new RuntimeException();

        } catch (Exception e) {
            System.out.println("catch block");
        } finally {
            System.out.println("finally block");
        }
    }
}
