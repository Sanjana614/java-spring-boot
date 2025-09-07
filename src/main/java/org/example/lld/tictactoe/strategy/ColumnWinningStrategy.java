package org.example.lld.tictactoe.strategy;

import org.example.lld.tictactoe.enums.Symbol;
import org.example.lld.tictactoe.model.Board;
import org.example.lld.tictactoe.model.Cell;
import org.example.lld.tictactoe.model.Player;

public class ColumnWinningStrategy implements WinningStrategy {
    @Override
    public boolean isWinningMove(Board board, Player player) {
        Symbol symbol = player.getSymbol();
        int size = board.getSize();
        Cell[][] cells = board.getCells();
        for (int col = 0; col < size; col++) {
            boolean colMatch = true;
            for (int row = 0; row < size; row++) {
                if (!symbol.equals(cells[row][col].getSymbol())) {
                    colMatch = false;
                    break;
                }
            }
            if (colMatch) {
                return true;
            }
        }
        return false;
    }
}
