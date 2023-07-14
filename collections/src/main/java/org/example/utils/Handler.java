package org.example.utils;

import org.example.Crate;

import java.util.ArrayList;
import java.util.List;

public class Handler {

    public static <T> void prepare(T t) {
        System.out.println("Preparing " + t);
    }

    public static <T> Crate<T> ship(T t) {
        System.out.println("Shipping " + t);
        return new Crate<T>();
    }

    public static void printList(List<? extends Object> list) {
        for (Object o : list) {
            System.out.println(o);
        }
    }

    public static void testPrintList() {
        List<String> keywords = new ArrayList<>();
        keywords.add("java");
        printList(keywords);
    }
}
