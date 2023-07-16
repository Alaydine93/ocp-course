package org.example;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.Spliterator;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AdvancedConcepts {

    public static void main(String... args){
        divideBag();
    }

    private static void threeDigit(Optional<Integer> optional){
        optional.map(n -> "" + n)
                .filter(s -> s.length() == 3)
                .ifPresent(System.out::println);
    }

    private static void divideBag(){
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

    private static void streamToMap(){
        var stream = Stream.of("lions", "tigers", "bears");
        TreeMap<Integer, List<String>> map = stream.collect(Collectors.groupingBy(
                String::length,
                TreeMap::new,
                Collectors.toList()));
    }

    private static void partitioningStream() {
        var stream = Stream.of("lions", "tigers", "bears");
        Map<Boolean, List<String>> map = stream.collect(Collectors.partitioningBy(s -> s.length() <= 5, Collectors.toList()));

    }
}
