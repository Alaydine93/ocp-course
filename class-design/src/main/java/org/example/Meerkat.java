package org.example;

public class Meerkat extends Carnivor {
    protected boolean hasFur = false;

    public static void main(String... args){
        Meerkat m = new Meerkat();
        Carnivor c = m;
        Object o = new Object();
    }
}
