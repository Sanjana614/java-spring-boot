package org.example.pattern.decorator.topping;

import org.example.pattern.decorator.Pizza;
import org.example.pattern.decorator.PizzaDecorator;

public class CheeseTopDecorator extends PizzaDecorator {
    private static final int PRICE = 12;

    public CheeseTopDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public int calculateCost() {
        return PRICE + super.calculateCost();
    }
}
