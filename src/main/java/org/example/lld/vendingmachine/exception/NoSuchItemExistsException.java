package org.example.lld.vendingmachine.exception;

public class NoSuchItemExistsException extends RuntimeException {

    public NoSuchItemExistsException(String code) {
//        System.out.println("Item with code " + code + " doesn't exists.");
        super("Item with code " + code + " doesn't exists.");
    }

}
