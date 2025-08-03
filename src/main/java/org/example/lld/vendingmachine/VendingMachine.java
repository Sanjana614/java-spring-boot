package org.example.lld.vendingmachine;

import org.apache.commons.lang3.math.NumberUtils;
import org.example.lld.vendingmachine.exception.ItemOutOfStockException;
import org.example.lld.vendingmachine.money.Money;
import org.example.lld.vendingmachine.state.IdleState;
import org.example.lld.vendingmachine.state.State;

import java.util.List;
import java.util.Objects;

public final class VendingMachine {
    private volatile static VendingMachine instance;
    private State currentState;
    private final Inventory inventory;
    private Item selectedItem;
    private int balance;

    private VendingMachine(Inventory inventory) {
        this.inventory = inventory;
        currentState = new IdleState(this);
    }

    public static VendingMachine getInstance(Inventory inventory) {
        if (Objects.isNull(instance)) {
            synchronized (VendingMachine.class) {
                if (Objects.isNull(instance)) {
                    instance = new VendingMachine(inventory);
                }
            }
        }
        return instance;
    }

    public void selectItem(String code) {
        currentState.selectItem(code);
    }

    public void makePayment(List<Money> amount) {
        currentState.makePayment(amount);
    }

    public void dispense() {
        currentState.dispense();
    }

    public void dispenseItem() {
        inventory.reduceStock(this.selectedItem.getCode());
        System.out.println("Item dispensed: " + selectedItem);
        reset();
    }

    public void setSelectedItem(String selectedItemCode) {
        Item item = inventory.getItem(selectedItemCode);
        int stock = inventory.getStock(selectedItemCode);
        if (NumberUtils.INTEGER_ZERO.equals(stock)) {
            throw new ItemOutOfStockException(selectedItemCode);
        }
        this.selectedItem = item;
    }

    public void reset() {
        balance = 0;
        selectedItem = null;
        currentState = new IdleState(this);
    }

    public void addMoney(int amount) {
        balance += amount;
    }

    public void refund(int amount) {
        System.out.println("Refunding excess amount: " + amount);
        balance -= amount;
    }

    public Item getSelectedItem() {
        return this.selectedItem;
    }

    public void setCurrentState(State currentState) {
        this.currentState = currentState;
    }

    public State getCurrentState() {
        return this.currentState;
    }

    public int getBalance() {
        return this.balance;
    }
}
