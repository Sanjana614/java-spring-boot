package org.example.lld.vendingmachine.state;

import org.example.lld.vendingmachine.Item;
import org.example.lld.vendingmachine.VendingMachine;
import org.example.lld.vendingmachine.money.Money;

import java.util.List;

public class ItemSelectedState extends State {

    public ItemSelectedState(VendingMachine vendingMachine) {
        super(vendingMachine);
    }

    @Override
    public void selectItem(String code) {
        System.out.println("Item already selected.");
    }

    @Override
    public void makePayment(List<Money> amount) {
        int paid = amount.stream().mapToInt(Money::getValue).sum();
        vendingMachine.addMoney(paid);
        Item selectedItem = vendingMachine.getSelectedItem();
        if (vendingMachine.getBalance() >= selectedItem.getPrice()) {
            System.out.println("Sufficient amount received.");
            int excessAmount = vendingMachine.getBalance() - selectedItem.getPrice();
            if (excessAmount > 0) {
                vendingMachine.refund(excessAmount);
            }
            vendingMachine.setCurrentState(new HasMoneyState(vendingMachine));
        }
    }

    @Override
    public void dispense() {
        System.out.println("Please add sufficient money.");
    }
}
