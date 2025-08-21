package org.example.lld.coffeevendingmachine.decorator;

import org.example.lld.coffeevendingmachine.enums.Ingredient;
import org.example.lld.coffeevendingmachine.templatemethod.Coffee;

import java.util.HashMap;
import java.util.Map;

public abstract class CoffeeDecorator extends Coffee {
    protected Coffee coffee;

    public CoffeeDecorator(Coffee coffee) {
        this.coffee = coffee;
    }

    public abstract Map<Ingredient, Integer> getAdditionalRecipe();

    @Override
    public int getPrice() {
        return coffee.getPrice();
    }

    @Override
    public void addCondiments() {
        coffee.addCondiments();
    }

    @Override
    public Map<Ingredient, Integer> getRecipe() {
        Map<Ingredient, Integer> newRecipe = new HashMap<>(coffee.getRecipe());
        getAdditionalRecipe().forEach((ingredient, quantity) -> {
            newRecipe.merge(ingredient, quantity, Integer::sum);
        });
        return newRecipe;
    }
}
