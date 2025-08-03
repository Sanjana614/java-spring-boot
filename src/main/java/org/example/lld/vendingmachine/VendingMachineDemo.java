package org.example.lld.vendingmachine;

import org.example.lld.vendingmachine.money.Coin;
import org.example.lld.vendingmachine.money.Money;

import java.util.ArrayList;
import java.util.List;

public class VendingMachineDemo {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        inventory.addItem("pepsi", "Pepsi", 20, 5);
        inventory.addItem("chips", "Chips", 10, 1);
        VendingMachine vendingMachine = VendingMachine.getInstance(inventory);
        List<Money> amount = new ArrayList<>();
        amount.add(Coin.FIFTY);

        vendingMachine.selectItem("pepsi");
        vendingMachine.makePayment(amount);
        vendingMachine.dispense();

        vendingMachine.selectItem("chips");
        vendingMachine.makePayment(amount);
        vendingMachine.dispense();

        vendingMachine.selectItem("chips");
        vendingMachine.makePayment(amount);
        vendingMachine.dispense();
    }
}
