package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class MapTests {

    final void printMapKeyValues() {
        Map<Integer, Character> map = new HashMap<>();
        map.put(1, 'a');
        map.put(2, 'b');
        map.put(3, 'c');
        map.forEach((k, v) -> System.out.println(v));

        map.values().forEach(System.out::println);

        map.entrySet().forEach(e -> System.out.println(e.getKey() + " " + e.getValue()));
    }

    void replaceValues() {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 2);
        map.put(2, 4);
        Integer original = map.replace(2, 10);
        System.out.println(map);
        map.replaceAll((k, v) -> k + v);
        System.out.println(map);
    }

    void mergingMaps() {
        BiFunction<String, String, String> mapper = (v1, v2) -> v1.length() > v2.length() ? v1 : v2;
        Map<String, String> favorites = new HashMap<>();
        favorites.put("Jenny", "Bus Tour");
        favorites.put("Tom", "Tram");

        String jenny = favorites.merge("Jenny", "Skyride", mapper);
        String tom = favorites.merge("Tom", "Skyride", mapper);

        System.out.println(favorites);
        System.out.println(jenny);
        System.out.println(tom);
    }

}
