package org.example;

public class Loops {

    public static void main(String[] args) {
        nestedDoWhile();
    }

    static void multipleTermsInFor() {
        int x = 0;
        for (long y = 0, z = 4; x < 5 && y < 10; x++, y++) {
            System.out.println("y" + y + " ");
        }
        System.out.println("x" + x + " ");
    }

    static void nestedLoops() {
        int[][] myComplexArray = {{5, 2, 1, 3}, {3, 9, 8, 9}, {5, 7, 12, 7}};

        OUTER_LOOP:
        for (int[] mySimpleArray : myComplexArray) {
            INNER_LOOP:
            for (int i = 0; i < mySimpleArray.length; i++) {
                System.out.print(mySimpleArray[i] + "\t");
            }
            System.out.println();
        }
    }

    static void nestedDoWhile() {
        int hungryHippo = 8;
        while (hungryHippo > 0) {
            do {
                hungryHippo -= 2;
            } while (hungryHippo > 5);
            hungryHippo--;
            System.out.print(hungryHippo + ",");
        }
    }
}
