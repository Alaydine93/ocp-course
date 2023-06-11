package packageb;

import packagea.ClassA;

public class ClassB {
    public static void main(String[] args) {
        ClassB b = new ClassB();
        System.out.println(b.pyramid);
    }

    String pyramid = """
              *
             * *
            * * *
            """;

    public void eatIfHungry(boolean hungry) {
        if (hungry) {
            int bitesOfCheese = 1;
            {
                var teenyBit = 1;
                System.out.println(bitesOfCheese);
            }
        }
        //System.out.println(teenyBit);
    }

    public ClassB() {
    }

}
