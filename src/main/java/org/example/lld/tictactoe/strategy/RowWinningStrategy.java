package org.example.lld.tictactoe.strategy;

import org.example.lld.tictactoe.enums.Symbol;
import org.example.lld.tictactoe.model.Board;
import org.example.lld.tictactoe.model.Cell;
import org.example.lld.tictactoe.model.Player;

public class RowWinningStrategy implements WinningStrategy {
    @Override
    public boolean isWinningMove(Board board, Player player) {
        Symbol symbol = player.getSymbol();
        int size = board.getSize();
        Cell[][] cells = board.getCells();
        for (int row = 0; row < size; row++) {
            boolean rowMatch = true;
            for (int col = 0; col < size; col++) {
                if (!symbol.equals(cells[row][col].getSymbol())) {
                    rowMatch = false;
                    break;
                }
            }
            if (rowMatch) {
                return true;
            }
        }
        return false;
    }
}
