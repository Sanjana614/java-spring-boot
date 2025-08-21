package org.example.lld.coffeevendingmachine.state;

import org.example.lld.coffeevendingmachine.CoffeeVendingMachine;
import org.example.lld.coffeevendingmachine.templatemethod.Coffee;

public class ReadyState implements VendingMachineState {

    @Override
    public void selectCoffee(CoffeeVendingMachine coffeeVendingMachine, Coffee coffee) {
        coffeeVendingMachine.setSelectedCoffee(coffee);
        coffeeVendingMachine.setCurrentState(new CoffeeSelectedState());
    }

    @Override
    public void addPayment(CoffeeVendingMachine coffeeVendingMachine, int amount) {
        System.out.println("Item not selected yet.");
    }

    @Override
    public void dispenseCoffee(CoffeeVendingMachine coffeeVendingMachine) {
        System.out.println("Item not selected yet.");
    }

    @Override
    public void cancel(CoffeeVendingMachine coffeeVendingMachine) {
        System.out.println("Item not selected yet.");
    }
}
