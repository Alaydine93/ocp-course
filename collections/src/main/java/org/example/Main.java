package org.example;

import org.example.utils.Handler;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Handler.prepare("Toto");
        Handler.ship(1);
    }

    private static void testDeque() {
        Deque<Integer> deque = new ArrayDeque<>(1);
        deque.offerFirst(10);
        deque.offerLast(4);
        deque.peekFirst();
        deque.peekFirst();
        deque.pollLast();
    }

    private static void testDequeAsStack() {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(10);
        stack.push(4);
        stack.peek();
        stack.poll();
        stack.poll();
    }

    private static void testMap() {
        Map<String, String> map = Map.ofEntries(
                Map.entry("key1", "value1"),
                Map.entry("key2", "value2")
        );
        Set<Map.Entry<String, String>> entrySet = map.entrySet();
        System.out.println(entrySet);
    }

    private static void testComparables() {
        Comparator<Duck> byWeight = Comparator.comparingInt(Duck::getWeight);
        var ducks = new ArrayList<Duck>();
        ducks.add(new Duck("Quack", 7));
        ducks.add(new Duck("Puddles", 10));
        Collections.sort(ducks);
        System.out.println(ducks);
        Collections.sort(ducks, byWeight);
        System.out.println(ducks);
    }

    private static void compareList() {
        List<String> bunnies = new ArrayList<>();
        bunnies.add("long ear");
        bunnies.add("floppy");
        bunnies.add("hoppy");
        System.out.println(bunnies);
        bunnies.sort(Comparator.naturalOrder());//(b1,b2) -> b1.compareTo(b2)
    }
}