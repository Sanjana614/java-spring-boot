package org.example.lld.vendingmachine.exception;


public class InsufficientAmountException extends RuntimeException {
    public InsufficientAmountException() {
//        System.out.println("Insufficient amount.");
        super("Insufficient amount.");
    }
}
