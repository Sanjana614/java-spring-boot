package org.example.lld.vendingmachine.money;

public enum Note implements Money {
    TEN(10),
    FIFTY(50),
    ONE_HUNDRED(100);

    Note(int value) {
        this.value = value;
    }

    private final int value;

    @Override
    public int getValue() {
        return value;
    }
}
