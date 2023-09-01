package org.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class IOStreams {

    private void readLazily(Path path) throws IOException {
        try(Stream<String> s = Files.lines(path)){
            s.filter( f -> f.startsWith("WARN:"))
                    .map(f -> f.substring(5))
                    .forEach(System.out::println);
        }
    }

    private void copyPathAsString(Path input, Path output) throws IOException {
        String string = Files.readString(input);
        Files.writeString(output, string);
    }

    void copyTextFile(File src, File dest) throws IOException {
        try(var reader = new BufferedReader(new FileReader(src));
        var writer = new BufferedWriter(new FileWriter(dest))) {
            String line;
            while((line = reader.readLine()) != null){
                writer.write(line);
                writer.newLine();
            }
        }
    }

    void copyStream(InputStream in, OutputStream out) throws IOException {
        int batchSize = 1024;
        byte[] buffer = new byte[batchSize];
        int lengthRead;
        while(in.read(buffer, 0, batchSize) > 0 ) {
            out.write(buffer, 0, batchSize);
            out.flush();
        }
    }

    void simpleCopyStream(InputStream in, OutputStream out) throws IOException {
        int b;
        while((b = in.read()) != -1){
            out.write(b);
        }
    }

    void copyStream(Reader in, Writer out) throws  IOException{
        int b ;
        while((b = in.read()) != -1){
            out.write(b);
        }
    }
}
