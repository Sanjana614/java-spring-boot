package org.example.lld.coffeevendingmachine.factory;

import org.example.lld.coffeevendingmachine.templatemethod.Coffee;
import org.example.lld.coffeevendingmachine.enums.CoffeeType;
import org.example.lld.coffeevendingmachine.templatemethod.Cappuccino;
import org.example.lld.coffeevendingmachine.templatemethod.Espresso;
import org.example.lld.coffeevendingmachine.templatemethod.Latte;

public class CoffeeFactory {

    public static Coffee getCoffee(CoffeeType coffeeType) {
        switch (coffeeType) {
            case LATTE:
                return new Latte();
            case ESPRESSO:
                return new Espresso();
            case CAPPUCCINO:
                return new Cappuccino();
            default:
                throw new IllegalArgumentException("Invalid coffee type: " + coffeeType);
        }
    }
}
