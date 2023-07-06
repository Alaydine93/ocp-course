package org.example;

import java.util.ArrayList;
import java.util.List;

public final class ImmutableAnimal {

    private final List<String> favoriteFood;

    public ImmutableAnimal() {
        this.favoriteFood = new ArrayList<>();
        this.favoriteFood.add("Apples");
        this.favoriteFood.add("Oranges");
        this.favoriteFood.add("Strawberries");
    }

    //Defensive copy
    public ImmutableAnimal(List<String> favorites) {
        if (favorites == null || favorites.size() == 0)
            throw new RuntimeException("Favorite is required");
        this.favoriteFood = new ArrayList<>(favorites);
    }

    public int getFavoriteFoodCount() {
        return favoriteFood.size();
    }

    public String getFavoriteFoodItem(int index) {
        return favoriteFood.get(index);
    }
}
