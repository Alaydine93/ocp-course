package org.example.nested;

public class Fox {

    private static class Ride{
        private int price;
    }

    private class Den {
    }

    public void goHome() {
        new Den();
        var ride = new Ride();
        System.out.println("nested static price not instanciated " + ride.price);
    }

    public static void visitFriend() {
        var fox = new Fox();
        fox.new Den();
    }
}

class Squirrel {
    public void visitFox() {
        var fox = new Fox();
        //fox.new Den(); NOT WORKING AS Den IS PRIVATE
    }
}
