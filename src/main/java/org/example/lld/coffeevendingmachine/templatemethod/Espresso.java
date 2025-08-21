package org.example.lld.coffeevendingmachine.templatemethod;

import org.example.lld.coffeevendingmachine.enums.CoffeeType;
import org.example.lld.coffeevendingmachine.enums.Ingredient;

import java.util.HashMap;
import java.util.Map;

public class Espresso extends Coffee {
    private final int price = 250;

    public Espresso() {
        this.coffeeType = CoffeeType.ESPRESSO.name();;
    }


    @Override
    public void addCondiments() {
//        Nothing to add.
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
        return recipe;
    }

}
