package org.example.lld.atmmachine.model;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private final String accountNumber;
    private int balance;
    private final List<Card> cards;

    public Account(String accountNumber, int initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        cards = new ArrayList<>();
    }

    public int getBalance() {
        return this.balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public synchronized boolean withdraw(int amount) {
        if (balance < amount) {
            System.out.println("Insufficient balance.");
            return false;
        }
        balance -= amount;
        return true;
    }

    public synchronized void deposit(int amount) {
        balance += amount;
    }
}
