package org.example.lld.vendingmachine.state;

import org.example.lld.vendingmachine.VendingMachine;
import org.example.lld.vendingmachine.money.Money;

import java.util.List;

public abstract class State {

    protected VendingMachine vendingMachine;

    public State(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    public abstract void selectItem(String code);

    public abstract void makePayment(List<Money> amount);

    public abstract void dispense();
}
