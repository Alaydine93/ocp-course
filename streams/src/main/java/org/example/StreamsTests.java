package org.example;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StreamsTests {
    public static void main(String[] args) {
        flatMapExample();
    }

    private static void infiniteStream() {
        Stream<Double> randoms = Stream.generate(Math::random);
        Stream<Integer> oddNumbers = Stream.iterate(1, n -> n + 2);
        Stream<Integer> oddNumbersUnder100 = Stream.iterate(1, n -> n < 100, n -> n + 2);
        System.out.println(oddNumbersUnder100.toList());
    }

    private static void finiteStream() {
        Stream<String> empty = Stream.empty();
        Stream<Integer> singleElement = Stream.of(1);
        Stream<Integer> fromArray = Stream.of(1, 2, 3);
        System.out.println(fromArray.count());

        var list = List.of("monkey", "ape", "3", "bonobo");
        Stream<String> fromList = list.stream();
        fromList.forEach(x -> System.out.println(x.length()));

        Stream<String> infinite = Stream.generate(() -> "toto");
        Predicate<String> pred = x -> Character.isLetter(x.charAt(0));
        System.out.println(list.stream().anyMatch(pred));
        System.out.println(list.stream().allMatch(pred));
        System.out.println(list.stream().noneMatch(pred));
        System.out.println(infinite.anyMatch(pred));
        System.out.println(infinite.allMatch(pred));//java.lang.IllegalStateException because stream is terminated

        Optional<String> min = fromList.min(Comparator.comparingInt(String::length));
        min.ifPresent(System.out::println);
    }

    private static void reduceStreams() {
        List<String> list = List.of("w", "o", "l", "f!");
        Stream<String> stream = list.stream();
        Stream<String> stream2 = list.stream();
        String word = stream.reduce("", (a, b) -> a + b);
        int length = stream2.reduce(0, (i, j) -> i + j.length(), (a, b) -> a + b);
        System.out.println(word + " with length of " + length);

        Stream<Integer> intStream = Stream.of(1, 2, 3, 4, 5);
        Optional<Integer> multiply = intStream.reduce((a, b) -> a * b);
        multiply.ifPresent(System.out::println);
    }

    private static StringBuilder collectToStringBuilder() {
        Stream<String> stream = Stream.of("w", "o", "l", "f");
        return stream.collect(StringBuilder::new, StringBuilder::append, StringBuilder::append);
    }

    private static void skipLimitStreams() {
        Stream.iterate(1, n -> n + 1)
                .skip(5)
                .limit(2)
                .forEach(System.out::println);
    }

    private static void mapListOfObjectToLengthInt() {
        Stream.of("monkey", "ape", "3", "bonobo")
                .map(String::length).forEach(System.out::println);
    }

    private static void flatMapExample() {
        List<String> zero = List.of();
        List<String> one = List.of("bonobo");
        List<String> two = List.of("mama gorilla", "baby gorilla");

        Stream<List<String>> animals = Stream.of(zero, one, two);
        animals.flatMap(m -> m.stream()).forEach(System.out::println);
    }

    private static void combinedPipelines() {
        Stream.of("Toby", "Anna", "Leroy", "Alex")
                .filter(x -> x.length() == 4)
                .sorted()
                .limit(2)
                .forEach(System.out::println);
    }
}
