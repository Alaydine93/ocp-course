package org.example;

import java.time.*;
import java.util.Arrays;

class Main {
    public static void main(String[] args) {
        var date = LocalDate.of(2022,5,25);
        var time = LocalTime.of(11,55,00);
        var zone = ZoneId.of("US/Eastern");
        var dateTimeZone = ZonedDateTime.of(date,time,zone);
        var instant = dateTimeZone.toInstant();
        System.out.println(dateTimeZone);
        System.out.println(instant);
    }

    private static void animalEnrichment() {
        var start = LocalDate.of(2022,Month.JANUARY,1);
        var end = LocalDate.of(2022,Month.MARCH,1);
        var period = Period.ofMonths(1);
        performAnimalEnrichment(start,end,period);
    }

    private static void performAnimalEnrichment(LocalDate start, LocalDate end, Period period) {
        var upTo = start;
        while(upTo.isBefore(end)){
            System.out.println("give me new toy " + upTo);
            upTo = upTo.plus(period);
        }
    }

    private static void manipulateDateTime() {
        var date = LocalDate.of(2024, Month.JANUARY, 20);
        var time = LocalTime.of(5,15);
        var dateTime = LocalDateTime.of(date, time);
        System.out.println(dateTime);
        dateTime = dateTime.minusDays(1);
        System.out.println(dateTime);
        dateTime = dateTime.minusHours(10);
        System.out.println(dateTime);
        dateTime = dateTime.minusSeconds(30);
        System.out.println(dateTime);
    }

    private static void binarySearchTest() {
        int[] numbers = {3,2,1};
        System.out.println(Arrays.binarySearch(numbers, 2));
        System.out.println(Arrays.binarySearch(numbers, 3));
    }

    private static void stringBuilderExample() {
        StringBuilder a = new StringBuilder("abc");
        StringBuilder b = a.append("de");
        b = b.append("f").append("g");
        System.out.println("a = " + a);
        System.out.println("b = " + b);

        var sb = new StringBuilder("animals");
        String sub = sb.substring(sb.indexOf("a"), sb.indexOf("al"));
        int len = sb.length();
        char ch = sb.charAt(6);
        System.out.println("%s %d %s".formatted(sub,len,ch));
    }

    private static void formattedExample() {
        var name = "Alae";
        var score = 90.25;
        var total = 100;

        System.out.println("%s:%n Score: [%06.2f] out of %d".formatted(name, score, total));
    }

    private static void translatingEscape() {
        var str = "&\\t2";
        System.out.println(str);
        System.out.println(str.translateEscapes());
    }

    private static void indentationExample() {
        var block = """
                a
                 b
                c""";

        var concat = " a\n"
                   + "  b\n"
                   + " c";

        System.out.println(block.length());
        System.out.println(concat.length());
        System.out.println(block.indent(1).length());
        System.out.println(concat.indent(-1).length());
        System.out.println(concat.indent(-4).length());
        System.out.println(concat.stripIndent().length());
    }
}