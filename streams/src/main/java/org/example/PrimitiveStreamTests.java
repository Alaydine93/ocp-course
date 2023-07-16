package org.example;

import java.util.IntSummaryStatistics;
import java.util.OptionalDouble;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class PrimitiveStreamTests {

    public static void main(String... args){
        mapToExamples();
    }

    private static void mapToExamples() {
        Stream<String> objStream = Stream.of("penguin", "fish");
        IntStream intStream = objStream.mapToInt(String::length);
        System.out.println("range is " + range(intStream));

        var stream = IntStream.rangeClosed(1,10);
        OptionalDouble optional = stream.average();
        optional.ifPresent(System.out::println);
    }

    private static int range(IntStream ints) {
        IntSummaryStatistics stats = ints.summaryStatistics();
        if(stats.getCount() == 0)
            throw new RuntimeException();
        return stats.getMax() - stats.getMin();
    }
}
