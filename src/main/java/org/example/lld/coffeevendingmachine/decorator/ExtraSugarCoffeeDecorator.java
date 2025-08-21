package org.example.lld.coffeevendingmachine.decorator;

import org.assertj.core.util.Maps;
import org.example.lld.coffeevendingmachine.enums.Ingredient;
import org.example.lld.coffeevendingmachine.templatemethod.Coffee;

import java.util.Map;

public class ExtraSugarCoffeeDecorator extends CoffeeDecorator {
    public final int price = 10;
    private final Map<Ingredient, Integer> ADDITIONAL_RECIPE = Maps.newHashMap(Ingredient.SUGAR, 1);

    public ExtraSugarCoffeeDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public Map<Ingredient, Integer> getAdditionalRecipe() {
        return ADDITIONAL_RECIPE;
    }

    @Override
    public int getPrice() {
        return coffee.getPrice() + price;
    }

    @Override
    public String getCoffeeType() {
        return super.getCoffeeType() + ", Extra sugar.";
    }
}
