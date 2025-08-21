package org.example.lld.coffeevendingmachine.state;

import org.example.lld.coffeevendingmachine.CoffeeVendingMachine;
import org.example.lld.coffeevendingmachine.Inventory;
import org.example.lld.coffeevendingmachine.templatemethod.Coffee;

public class PaymentDoneState implements VendingMachineState {

    @Override
    public void selectCoffee(CoffeeVendingMachine coffeeVendingMachine, Coffee coffee) {
        System.out.println("Coffee already selected.");
    }

    @Override
    public void addPayment(CoffeeVendingMachine coffeeVendingMachine, int amount) {
        System.out.println("Already sufficient amount received. Refunding amount: " + amount);
    }

    @Override
    public void dispenseCoffee(CoffeeVendingMachine coffeeVendingMachine) {
        Coffee coffee = coffeeVendingMachine.getSelectedCoffee();
        Inventory inventory = coffeeVendingMachine.getInventory();
        if (!inventory.hasStocks(coffee.getRecipe())) {
            System.out.println("Unable to dispense coffee. Ingredient not available.");
            coffeeVendingMachine.setCurrentState(new IngredientOutOfStockState());
            cancel(coffeeVendingMachine);
            return;
        }
        coffeeVendingMachine.setCurrentState(new CoffeeDispensingState());
        inventory.reduceStocks(coffee.getRecipe());
        coffee.prepare();
        coffeeVendingMachine.reset();
        System.out.println(coffee.getCoffeeType() + " served.");
    }

    @Override
    public void cancel(CoffeeVendingMachine coffeeVendingMachine) {
        Coffee coffee = coffeeVendingMachine.getSelectedCoffee();
        System.out.println("Order Cancelled. Refunding amount: " + coffee.getPrice());
        coffeeVendingMachine.reset();
    }
}
