package org.example.lld.tictactoe.model;

import org.example.lld.tictactoe.enums.Symbol;

public class Board {
    private int movesCount;
    private Cell[][] cells;
    private final int size;

    public Board(int size) {
        this.size = size;
        this.cells = new Cell[size][size];
        this.movesCount = 0;
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                this.cells[i][j] = new Cell();
            }
        }
    }

    public void printBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(this.cells[i][j] + " ");
            }
            System.out.println();
        }
    }

    public Symbol getSymbol(int x, int y) {
        if (invalidPosition(x, y)) {
            System.out.println("Invalid position");
            return null;
        }
        return this.cells[x][y].getSymbol();
    }

    public void placeSymbol(int x, int y, Symbol symbol) {
        if (invalidPosition(x, y)) {
            System.out.println("Invalid position");
            return;
        }
        this.cells[x][y].setSymbol(symbol);
    }

    public boolean invalidPosition(int x, int y) {
        return x < 0
                || x >= size
                || y < 0
                || y >= size;
    }

    public void increaseMoveCount() {
        this.movesCount += 1;
    }

    public int getMovesCount() {
        return this.movesCount;
    }

    public int getSize() {
        return this.size;
    }

    public Cell[][] getCells() {
        return cells;
    }

    public boolean isFull() {
        return movesCount == size*size;
    }
}
