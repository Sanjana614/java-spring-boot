package org.example.lld.atmmachine.model;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class BankService {
    private final Map<String, Card> cardMap = new ConcurrentHashMap<>();
    private final Map<String, Account> accountMap = new ConcurrentHashMap<>();
    private final Map<Card, Account> cardAccountMap = new ConcurrentHashMap<>();

    public BankService() {
        Account account1 = new Account("1234567890", 1000);
        Card card1 = new Card("1234-5678-9012-3456", "1234");
        cardMap.put(card1.getCardNumber(), card1);
        accountMap.put(account1.getAccountNumber(), account1);
        cardAccountMap.put(card1, account1);

        Account account2 = new Account("9876543210", 500);
        Card card2 = new Card("9876-5432-1098-7654", "4321");
        cardMap.put(card2.getCardNumber(), card2);
        accountMap.put(account2.getAccountNumber(), account2);
        cardAccountMap.put(card2, account2);
    }

    public Card fetchCard(String cardNumber) {
        return cardMap.get(cardNumber);
    }

    public Account fetchAccount(Card card) {
        return cardAccountMap.get(card);
    }

    public int fetchBalance(Card card) {
        Account account = fetchAccount(card);
        return account.getBalance();
    }

    public boolean withdrawAmount(Card card, int amount) {
        Account account = fetchAccount(card);
        if (account.getBalance() < amount) {
            System.out.println("Insufficient balance!!");
            return false;
        }
        account.withdraw(amount);
        return true;
    }

    public void depositAmount(Card card, int amount) {
        Account account = fetchAccount(card);
        account.deposit(amount);
    }
}
