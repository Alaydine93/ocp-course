package org.example;

class Food{}
class Water{}

public record Fox(String name) {
    public void eatAndDrink(Food food, Water water){
        synchronized (food){
            System.out.println(name() + " Got food!");
            move();
            synchronized (water) {
                System.out.println(name() + " Got water!");
            }
        }
    }
    public void drinkAndEat(Food food, Water water){
        synchronized (water){
            System.out.println(name() + " Got water!");
            move();
            synchronized (food){
                System.out.println(name() + " Got food!");
            }
        }
    }
    public void move(){
        try {
            Thread.sleep(100);
        } catch (InterruptedException e){

        }
    }
}
