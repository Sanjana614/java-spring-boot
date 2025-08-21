package org.example.lld.coffeevendingmachine.decorator;

import org.assertj.core.util.Maps;
import org.example.lld.coffeevendingmachine.enums.Ingredient;
import org.example.lld.coffeevendingmachine.templatemethod.Coffee;

import java.util.Map;

public class CaramelSyrupCoffeeDecorator extends CoffeeDecorator {
    private final int price = 30;
    private final Map<Ingredient, Integer> ADDITIONAL_RECIPE = Maps.newHashMap(Ingredient.CARAMEL_SYRUP, 10);

    public CaramelSyrupCoffeeDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public Map<Ingredient, Integer> getAdditionalRecipe() {
        return ADDITIONAL_RECIPE;
    }

    @Override
    public int getPrice() {
        return super.getPrice() + price;
    }

    @Override
    public String getCoffeeType() {
        return super.getCoffeeType() + ", Carmel Syrup.";
    }
}
