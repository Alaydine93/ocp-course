package org.example.nested;

public class Home {

    private String greeting = "Hi";

    public class Room {
        public int repeat = 3;

        public void enter() {
            for (int i = 0; i < repeat; i++)
                greet(greeting);
        }

        public static void greet(String message) {
            System.out.println(message);
        }
    }
}
