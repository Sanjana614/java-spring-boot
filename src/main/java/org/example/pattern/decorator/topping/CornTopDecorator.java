package org.example.pattern.decorator.topping;

import org.example.pattern.decorator.Pizza;
import org.example.pattern.decorator.PizzaDecorator;

public class CornTopDecorator extends PizzaDecorator {
    private static final int PRICE = 10;

    public CornTopDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public int calculateCost() {
        return PRICE + super.calculateCost();
    }
}
