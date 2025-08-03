package org.example.lld.vendingmachine.exception;

public class ItemOutOfStockException extends RuntimeException {
    public ItemOutOfStockException(String code) {
//        System.out.println("Item with code: " + code + " is out of stock.");
        super("Item with code: " + code + " is out of stock.");
    }
}
