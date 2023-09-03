package org.example;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Path path = Paths.get("/Users/alae-eddine/Dev/zoo.txt");
        normalizePath();
        System.out.println();

        var gorillas = new ArrayList<Gorilla>();
        gorillas.add(new Gorilla("Grodd", 5, false));
        gorillas.add(new Gorilla("Ishmael", 8, true));
        File dataFile = new File("gorilla.data");
        saveToFile(gorillas, dataFile);
        var gorillasFromDisk = readFromFile(dataFile);
    }

    static List<Gorilla> readFromFile(File dataFile) throws IOException, ClassNotFoundException {
        var gorillas = new ArrayList<Gorilla>();
        try (var in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(dataFile)))) {
            while (true) {
                var object = in.readObject();
                if (object instanceof Gorilla g)
                    gorillas.add(g);
            }
        } catch (EOFException e) {

        }
        return gorillas;
    }

    static void saveToFile(List<Gorilla> gorillas, File dataFile) throws IOException {
        try (var out = new ObjectOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream(dataFile)))) {
            for (Gorilla gorilla : gorillas) {
                out.writeObject(gorilla);
            }
        }
    }

    public void copyPath(Path source, Path target) {
        try {
            Files.copy(source, target);
            if (Files.isDirectory(source)) {
                try (Stream<Path> stream = Files.list(source)) {
                    stream.forEach(p -> copyPath(p, target.resolve(p.getFileName())));
                }
            }
        } catch (IOException e) {

        }
    }

    public static void normalizePath() {
        var p1 = Paths.get("/pony/../weather.txt");
        var p2 = Paths.get("/weather.txt");
        System.out.println(p1.equals(p2));
        System.out.println(p1.normalize().equals(p2));
    }

    public static void relativizingPaths() {
        var path1 = Path.of("fish.txt");
        var path2 = Path.of("friendly/birds.txt");
        System.out.println(path1.relativize(path2));
        System.out.println(path2.relativize(path1));
        System.out.println();
        var path3 = Path.of("/habitat");
        var path4 = Path.of("/sanctuary/raven/poe.txt");
        System.out.println(path3.relativize(path4));
        System.out.println(path4.relativize(path3));
    }

    public static void printPathInformation(Path path) {
        System.out.println("Filename is: " + path.getFileName());
        System.out.println(" Root is: " + path.getRoot());
        Path currentParent = path;
        while ((currentParent = currentParent.getParent()) != null)
            System.out.println(" Current parent is: " + currentParent);
        System.out.println();
    }

    public static void viewPath() {
        Path path = Paths.get("·/zoo.txt");
        System.out.println("The path name is " + path);
        for (int i = 0; i < path.getNameCount(); i++)
            System.out.println(" Element " + i + " is " + path.getName(i));
        System.out.println();
        System.out.println("subpath(0,3): " + path.subpath(0, 3));
        System.out.println("subpath(1,2): " + path.subpath(1, 2));
        System.out.println("subpath(1,3): " + path.subpath(1, 3));
    }

    public static void nio() throws IOException {
        var path = Path.of("/Users/alae-eddine/Dev");
        if (Files.exists(path)) {
            System.out.println("Absolute Path: " + path.toAbsolutePath());
            System.out.println("Is Directory: " + Files.isDirectory(path));
            System.out.println("Parent Path: " + path.getParent());
            if (Files.isRegularFile(path)) {
                System.out.println("Size: " + Files.size(path));
                System.out.println("Last modified: " + Files.getLastModifiedTime(path));
            } else {
                try (Stream<Path> stream = Files.list(path)) {
                    stream.forEach(p -> System.out.println(" " + p.getFileName()));
                }
            }
        }
    }

    public static void io() throws IOException {
        var file = new File("/Users/alae-eddine/Dev/zoo.txt");
        if (file.exists()) {
            System.out.println("Absolute Path: " + file.getAbsolutePath());
            System.out.println("Is Directory: " + file.isDirectory());
            System.out.println("Parent Path: " + file.getParent());
            if (file.isFile()) {
                System.out.println("Size: " + file.length());
                System.out.println("Last Modified: " + file.lastModified());
            } else {
                for (File subfile : file.listFiles()) {
                    System.out.println(" " + subfile.getName());
                }
            }
        }
    }

    private static void createFile() {
        File zooFile1 = new File("/Users/alae-eddine/Dev/stripes.txt");
        File zooFile2 = new File("/Users/alae-eddine", "/Dev/stripes.txt");
        File parent = new File("/Users/alae-eddine");
        File zooFile3 = new File(parent, "/Dev/stripes.txt");
        Path zooPath = zooFile3.toPath();
        System.out.println(zooFile1.exists());
    }

    private static void createFileUsingPath() {
        Path zooPath1 = Path.of("/Users/alae-eddine/Dev/stripes.txt");
        Path zooPath2 = Path.of("/User", "alae-eddine", "Dev", "stripes.txt");
        Path zooPath11 = FileSystems.getDefault().getPath("/Users/alae-eddine/Dev/stripes.txt");

        Path zooPath3 = Paths.get("/Users/alae-eddine/Dev/stripes2.txt");
        Path zooPath4 = Paths.get("/User", "alae-eddine", "Dev", "stripes2.txt");
        File zooFile = zooPath3.toFile();
    }
}