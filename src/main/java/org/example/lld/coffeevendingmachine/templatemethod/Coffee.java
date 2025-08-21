package org.example.lld.coffeevendingmachine.templatemethod;

import org.example.lld.coffeevendingmachine.enums.Ingredient;

import java.util.Map;

public abstract class Coffee {
    protected String coffeeType = "Unknown type";

    public final void prepare() {
        System.out.println("preparing your " + this.getCoffeeType() + "...");
        grindBeans();
        brew();
        addCondiments();
        pourIntoCup();
        System.out.println(this.getCoffeeType() + " is ready.");
    }

    public abstract void addCondiments();

    private void grindBeans() {
        System.out.println("Grinding fresh coffee beans.");
    }

    private void brew() {
        System.out.println("Brewing hot coffee with water.");
    }

    private void pourIntoCup() {
        System.out.println("Pouring into a cup.");
    }

    public String getCoffeeType() {
        return coffeeType;
    }

    public abstract int getPrice();

    public abstract Map<Ingredient, Integer> getRecipe();
}
