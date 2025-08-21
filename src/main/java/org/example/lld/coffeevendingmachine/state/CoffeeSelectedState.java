package org.example.lld.coffeevendingmachine.state;

import org.example.lld.coffeevendingmachine.CoffeeVendingMachine;
import org.example.lld.coffeevendingmachine.templatemethod.Coffee;

public class CoffeeSelectedState implements VendingMachineState {

    @Override
    public void selectCoffee(CoffeeVendingMachine coffeeVendingMachine, Coffee coffee) {
        System.out.println("Already selected. Please pay or cancel.");
    }

    @Override
    public void addPayment(CoffeeVendingMachine vendingMachine, int amount) {
        vendingMachine.setMoneyInserted(vendingMachine.getMoneyInserted() + amount);
        Coffee coffee = vendingMachine.getSelectedCoffee();
        int coffeePrice = coffee.getPrice();
        if (vendingMachine.getMoneyInserted() >= coffeePrice) {
            vendingMachine.setCurrentState(new PaymentDoneState());
            int excessAmount = vendingMachine.getMoneyInserted() - coffeePrice;
            if (excessAmount > 0) {
                System.out.println("Refunding excess amount: " + excessAmount);
            }
        }
    }

    @Override
    public void dispenseCoffee(CoffeeVendingMachine coffeeVendingMachine) {
        System.out.println("Please add enough money.");
    }

    @Override
    public void cancel(CoffeeVendingMachine coffeeVendingMachine) {
        System.out.println("Refunding money: " + coffeeVendingMachine.getMoneyInserted());
        coffeeVendingMachine.reset();
    }
}
