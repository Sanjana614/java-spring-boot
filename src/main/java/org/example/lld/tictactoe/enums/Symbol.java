package org.example.lld.tictactoe.enums;

public enum Symbol {
    O("O"),
    X("X"),
    EMPTY("_");

    private final String symbol;

    Symbol(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
