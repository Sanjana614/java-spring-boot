package org.example.lld.coffeevendingmachine.templatemethod;

import org.example.lld.coffeevendingmachine.enums.CoffeeType;
import org.example.lld.coffeevendingmachine.enums.Ingredient;

import java.util.HashMap;
import java.util.Map;

public class Cappuccino extends Coffee {
    private final int price = 200;

    public Cappuccino() {
        this.coffeeType = CoffeeType.CAPPUCCINO.name();
    }

    @Override
    public void addCondiments() {
        System.out.println("- Adding steamed milk and foam.");
    }

    @Override
    public int getPrice() {
        return this.price;
    }

    @Override
    public Map<Ingredient, Integer> getRecipe() {
        Map<Ingredient, Integer> recipe = new HashMap<>();
        recipe.put(Ingredient.COFFEE_BEANS, 7);
        recipe.put(Ingredient.WATER, 30);
        recipe.put(Ingredient.MILK, 100);
        return recipe;
    }
}
