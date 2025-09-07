package org.example.lld.tictactoe.strategy;

import org.example.lld.tictactoe.enums.Symbol;
import org.example.lld.tictactoe.model.Board;
import org.example.lld.tictactoe.model.Cell;
import org.example.lld.tictactoe.model.Player;

public class DiagonalWinningStrategy implements WinningStrategy {

    @Override
    public boolean isWinningMove(Board board, Player player) {
        Symbol symbol = player.getSymbol();
        int size = board.getSize();
        Cell[][] cells = board.getCells();
        return mainDiagonalMatch(size, symbol, cells)
                || antiDiagonalMatch(size, symbol, cells);
    }

    private boolean antiDiagonalMatch(int size, Symbol symbol, Cell[][] cells) {
        for (int k = 0; k < size; k++) {
            if (!symbol.equals(cells[k][size-k-1].getSymbol())) {
                return false;
            }
        }
        return true;
    }

    private boolean mainDiagonalMatch(int size, Symbol symbol, Cell[][] cells) {
        for (int k = 0; k < size; k++) {
            if (!symbol.equals(cells[k][k].getSymbol())) {
                return false;
            }
        }
        return true;
    }
}
