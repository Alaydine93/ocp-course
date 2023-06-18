package org.example;

public class Switch {

    final int getCookies() {
        return 3;
    }

    void feedAnimals(int numberOfAnimals) {
        final int bananas = 1;
        int apples = 2;
        final int cookies = getCookies();

        switch (numberOfAnimals) {
            case bananas:
                System.out.println("bananas");
                break;
            case 2 * 4:
                System.out.println("operation");
                break;
            default:
                System.out.println("default");
        }
    }

    void printDayOfWeek(int day) {
        var result = switch (day) {
            case 0 -> "Sunday";
            case 1 -> "Monday";
            case 2 -> "Tuesday";
            case 3 -> "Wednesday";
            case 4 -> "Thursday";
            case 5 -> "Friday";
            case 6 -> "Saturday";
            default -> "Invalid value";
        };
        System.out.println(result);
    }

    void printSeason(int month) {
        switch (month) {
            case 1, 2, 3 -> System.out.println("Winter");
            case 4, 5, 6 -> System.out.println("Spring");
            case 7, 8, 9 -> System.out.println("Summer");
            case 10, 11, 12 -> System.out.println("Fall");
        }
    }
}
