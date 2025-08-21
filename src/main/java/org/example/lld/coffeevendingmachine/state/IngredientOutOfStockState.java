package org.example.lld.coffeevendingmachine.state;

import org.example.lld.coffeevendingmachine.CoffeeVendingMachine;
import org.example.lld.coffeevendingmachine.templatemethod.Coffee;

public class IngredientOutOfStockState implements VendingMachineState {

    @Override
    public void selectCoffee(CoffeeVendingMachine coffeeVendingMachine, Coffee coffee) {
        System.out.println("Ingredient out of stock.");
    }

    @Override
    public void addPayment(CoffeeVendingMachine coffeeVendingMachine, int amount) {
        System.out.println("Ingredient out of stock. Refunding " + amount);
    }

    @Override
    public void dispenseCoffee(CoffeeVendingMachine coffeeVendingMachine) {
        System.out.println("Ingredient out of stock.");
    }

    @Override
    public void cancel(CoffeeVendingMachine coffeeVendingMachine) {
        System.out.println("Cancelled!!");
        coffeeVendingMachine.reset();
    }
}
