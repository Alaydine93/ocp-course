package org.example;

public class FindInMatrix {

    public static void main(String... args) {
        cleaningSchedule();
    }

    private static void findInMatrix() {
        int[][] list = {{1, 13}, {5, 2}, {2, 2}};
        int searchValue = 2;
        int posX = -1;
        int posY = -1;
        PARENT_LOOP:
        for (int i = 0; i < list.length; i++) {
            for (int j = 0; j < list[i].length; j++) {
                if (list[i][j] == searchValue) {
                    posX = i;
                    posY = j;
                    break PARENT_LOOP;
                }
            }
        }
        if (posX == -1 || posY == -1) {
            System.out.println("Value " + searchValue + "not found");
        } else {
            System.out.println("Value " + searchValue + "found at : " +
                    "(" + posX + "," + posY + ")");
        }
    }

    static void cleaningSchedule() {
        CLEANING:
        for (char stables = 'a'; stables <= 'd'; stables++) {
            for (int leopard = 1; leopard < 4; leopard++) {
                if (stables == 'b' || leopard == 2) {
                    continue CLEANING;
                }
                System.out.println("Cleaning " + stables + "," + leopard);
            }
        }
    }
}
