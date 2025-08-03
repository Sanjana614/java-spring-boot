package org.example.lld.vendingmachine.money;

public enum Coin implements Money {
    ONE(1),
    FIVE(5),
    TEN(10),
    FIFTY(50);


    Coin(int value) {
        this.value = value;
    }

    private final int value;


    @Override
    public int getValue() {
        return this.value;
    }

}
