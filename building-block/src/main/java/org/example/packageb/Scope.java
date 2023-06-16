package org.example.packageb;

public class Scope {
    int login;
    char test;

    public void Scope(){

    }

    public static void main(String... args) {
        String one, two;
        one = new String("1");
        var num1 = Long.valueOf(one);
        two = new String("b");
        one = two;
        String three = one;
        one = null;


        String str = "toto";
        StringBuilder sb = new StringBuilder(str);
        if (str.equals(sb.reverse()))
            sb.append(sb);
        sb.length();
    }
}
