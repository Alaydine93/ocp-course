package org.example;

import java.util.IntSummaryStatistics;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class PrimitiveStreamTests {

    public static void main(String... args) {
        anotherTest();
    }

    private static void mapToExamples() {
        Stream<String> objStream = Stream.of("penguin", "fish");
        IntStream intStream = objStream.mapToInt(String::length);
        System.out.println("range is " + range(intStream));

        var stream = IntStream.rangeClosed(1, 10);
        OptionalDouble optional = stream.average();
        optional.ifPresent(System.out::println);
    }

    private static int range(IntStream ints) {
        IntSummaryStatistics stats = ints.summaryStatistics();
        if (stats.getCount() == 0) {
            throw new RuntimeException();
        }
        return stats.getMax() - stats.getMin();
    }

    private static void anotherTest() {
        LongStream longs = LongStream.of(5, 10);
        long sum = longs.sum();
        System.out.println(sum);
        DoubleStream doubles = DoubleStream.generate(() -> Math.PI).limit(3);
        OptionalDouble min = doubles.min();
        DoubleStream emptyDouble = DoubleStream.empty();
        System.out.println(min.orElseGet(() -> Double.NaN));
        System.out.println(emptyDouble.min().orElse(Double.NaN));
    }

    public static int max(IntStream ints) {
        OptionalInt optional = ints.max();
        return optional.orElseThrow(RuntimeException::new);
    }


}
