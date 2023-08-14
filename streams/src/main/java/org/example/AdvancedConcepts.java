package org.example;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Spliterator;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AdvancedConcepts {

    public static void main(String... args) {
        seperations();
    }

    private static void threeDigit(Optional<Integer> optional) {
        optional.map(n -> "" + n)
                .filter(s -> s.length() == 3)
                .ifPresent(System.out::println);
    }

    private static void divideBag() {
        var stream = List.of("bird-", "bunny-", "cat-", "dog-", "fish-", "lamb-", "mouse-");
        Spliterator<String> originalBagOfFood = stream.spliterator();
        Spliterator<String> emmasBag = originalBagOfFood.trySplit();
        emmasBag.forEachRemaining(System.out::print);
        System.out.println();
        Spliterator<String> jillsBag = originalBagOfFood.trySplit();
        jillsBag.tryAdvance(System.out::print);
        System.out.println();
        jillsBag.forEachRemaining(System.out::print);
    }

    private static void collectToString() {
        var stream = Stream.of("lions", "tigers", "bears");
        String result = stream.collect(Collectors.joining(", "));
        System.out.println(result);
    }

    private static void averageLength() {
        var stream = Stream.of("lions", "tigers", "bears");
        Double result = stream.collect(Collectors.averagingInt(String::length));
        System.out.println(result);
    }

    private static void streamToSet() {
        var stream = Stream.of("lions", "tigers", "bears");
        TreeMap<Integer, List<String>> map = stream.collect(Collectors.groupingBy(
                String::length,
                TreeMap::new,
                Collectors.toList()));
        System.out.println(map);
    }

    private static void streamToMap() {
        var stream = Stream.of("lions", "tigers", "bears");
        Map<String, Integer> map = stream.collect(Collectors.toMap(Function.identity(), String::length));
        System.out.println(map);
    }

    private static void reverseStreamToMap() {
        var stream = Stream.of("lions", "tigers", "bears");
        TreeMap<Integer, String> map = stream.collect(Collectors.toMap(
                String::length,
                Function.identity(),
                (s1, s2) -> s1 + ", " + s2,
                TreeMap::new));
        System.out.println(map);
    }

    private static void partitioningStream() {
        var stream = Stream.of("lions", "tigers", "bears");
        Map<Boolean, List<String>> map = stream.collect(Collectors.partitioningBy(s -> s.length() <= 5, Collectors.toList()));
    }

    private static void groupingByLength() {
        var stream = Stream.of("lions", "tigers", "bears");
        Map<Integer, Long> map = stream.collect(Collectors.groupingBy(String::length, Collectors.counting()));
        System.out.println(map);
    }

    private static void mappingBy() {
        var stream = Stream.of("lions", "tigers", "bears");
        Map<Integer, Optional<Character>> map = stream.collect(
                Collectors.groupingBy(
                        String::length,
                        Collectors.mapping(s -> s.charAt(0), Collectors.minBy((a,b)->a -b))));
        System.out.println(map);
    }

    private static void seperations() {
        var list = List.of("x", "y", "y");
        Separations result = list.stream().collect(
                Collectors.teeing(
                        Collectors.joining(" "),
                        Collectors.joining(","), (s,c) -> new Separations(s,c)));
        System.out.println(result);
    }
}
