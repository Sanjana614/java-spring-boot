package org.example.lld.coffeevendingmachine.state;

import org.example.lld.coffeevendingmachine.CoffeeVendingMachine;
import org.example.lld.coffeevendingmachine.templatemethod.Coffee;

public interface VendingMachineState {

    void selectCoffee(CoffeeVendingMachine coffeeVendingMachine, Coffee coffee);

    void addPayment(CoffeeVendingMachine coffeeVendingMachine, int amount);

    void dispenseCoffee(CoffeeVendingMachine coffeeVendingMachine);

    void cancel(CoffeeVendingMachine coffeeVendingMachine);
}
