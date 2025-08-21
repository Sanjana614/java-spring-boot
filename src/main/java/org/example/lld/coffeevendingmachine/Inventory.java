package org.example.lld.coffeevendingmachine;

import org.example.lld.coffeevendingmachine.enums.Ingredient;

import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private Map<Ingredient, Integer> stock = new HashMap<>();

    public void addStock(Map<Ingredient, Integer> ingredients) {
        ingredients.forEach((ingredient, quantity) -> {
            stock.put(ingredient, stock.getOrDefault(ingredient, 0) + quantity);
        });
    }

    public void reduceStocks(Map<Ingredient, Integer> recipe) {
        if (!hasStocks(recipe)) {
            System.out.println("Ingredients not sufficient.");
            return;
        }
        recipe.forEach((ingredient, quantity) -> {
            stock.put(ingredient, stock.get(ingredient) - quantity);
        });
    }

    public boolean hasStocks(Map<Ingredient, Integer> recipe) {
        return recipe.keySet().stream().allMatch(ingredient -> {
            Integer required = recipe.getOrDefault(ingredient, 0);
            Integer available = stock.getOrDefault(ingredient, 0);
            return available >= required;
        });
    }

    public void printInventory() {
        stock.forEach(((ingredient, qty) -> System.out.println(ingredient + " : " + qty)));
    }
}
