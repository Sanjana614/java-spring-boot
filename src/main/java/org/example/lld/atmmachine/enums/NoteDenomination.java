package org.example.lld.atmmachine.enums;

public enum NoteDenomination {

    TWENTY(20),
    FIFTY(50),
    HUNDRED(100);

    private final int value;

    NoteDenomination(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
