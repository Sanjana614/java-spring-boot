package org.example.lld.tictactoe.model;

import org.example.lld.tictactoe.enums.Symbol;

public class Cell {

    private Symbol symbol;

    public Cell() {
        this.symbol = Symbol.EMPTY;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return "Cell{" +
                "symbol=" + symbol +
                '}';
    }
}
