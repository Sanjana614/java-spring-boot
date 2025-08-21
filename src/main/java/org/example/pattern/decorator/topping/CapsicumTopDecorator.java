package org.example.pattern.decorator.topping;

import org.example.pattern.decorator.Pizza;
import org.example.pattern.decorator.PizzaDecorator;

public class CapsicumTopDecorator extends PizzaDecorator {
    public static final int PRICE = 8;

    public CapsicumTopDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public int calculateCost() {
        return PRICE + super.calculateCost();
    }
}
