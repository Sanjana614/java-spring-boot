package org.example.lld.coffeevendingmachine.state;

import org.example.lld.coffeevendingmachine.CoffeeVendingMachine;
import org.example.lld.coffeevendingmachine.templatemethod.Coffee;

public class CoffeeDispensingState implements VendingMachineState {

    @Override
    public void selectCoffee(CoffeeVendingMachine coffeeVendingMachine, Coffee coffee) {
        System.out.println("Already selected.");
    }

    @Override
    public void addPayment(CoffeeVendingMachine coffeeVendingMachine, int amount) {
        System.out.println("Already sufficient amount added. Refunding amount: " + amount);
    }

    @Override
    public void dispenseCoffee(CoffeeVendingMachine coffeeVendingMachine) {
        System.out.println("In progress...");
    }

    @Override
    public void cancel(CoffeeVendingMachine coffeeVendingMachine) {
        System.out.println("Unable to cancel. Dispensing in progress...");
    }
}
