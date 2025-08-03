package org.example.lld.vendingmachine.state;

import org.example.lld.vendingmachine.VendingMachine;
import org.example.lld.vendingmachine.money.Money;

import java.util.List;

public class DispensingState extends State {

    public DispensingState(VendingMachine vendingMachine) {
        super(vendingMachine);
    }

    @Override
    public void selectItem(String code) {
        System.out.println("Item already selected.");
    }

    @Override
    public void makePayment(List<Money> amount) {
        System.out.println("Already received sufficient amount.");
        System.out.println("Refunding amount: " + amount);
    }

    @Override
    public void dispense() {
        System.out.println("In progress.");
    }
}
