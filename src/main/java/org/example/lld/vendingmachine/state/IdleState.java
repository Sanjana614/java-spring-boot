package org.example.lld.vendingmachine.state;

import org.example.lld.vendingmachine.VendingMachine;
import org.example.lld.vendingmachine.money.Money;

import java.util.List;

public class IdleState extends State {

    public IdleState(VendingMachine vendingMachine) {
        super(vendingMachine);
    }

    @Override
    public void selectItem(String code) {
        vendingMachine.setSelectedItem(code);
        vendingMachine.setCurrentState(new ItemSelectedState(vendingMachine));
    }

    @Override
    public void makePayment(List<Money> amount) {
        System.out.println("Item not selected yet.");
    }

    @Override
    public void dispense() {
        System.out.println("Item not selected yet.");
    }
}
