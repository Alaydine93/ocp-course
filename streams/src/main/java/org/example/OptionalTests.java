package org.example;

import java.util.Optional;

public class OptionalTests {
    public static void main(String[] args) {
        Optional<Double> opt = average(17,15,19);
        opt.ifPresent(System.out::println);

        Optional<Double> emptyOpt = average();
        System.out.println(emptyOpt.orElse(Double.NaN));
        System.out.println(emptyOpt.orElseGet(() -> Math.random()));
        System.out.println(emptyOpt.orElseThrow());
        System.out.println(emptyOpt.orElseThrow(() -> new IllegalArgumentException()));

    }

    public static Optional<Double> average(int... scores) {
        if (scores.length == 0)
            return Optional.empty();
        int sum = 0;
        for (int score : scores)
            sum += score;
        return Optional.of((double) sum / scores.length);
    }
}
