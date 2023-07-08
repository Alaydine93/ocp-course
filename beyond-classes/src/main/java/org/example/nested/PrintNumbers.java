package org.example.nested;

public class PrintNumbers {
    private int length = 5;

    public void calculate(){
        final int width = 20;
        class Calculator {
            public void multiply(){
                System.out.println(length * width);
            }
        }
        var calculator = new Calculator();
        calculator.multiply();
    }
}
