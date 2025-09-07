package org.example.lld.tictactoe.strategy;

import org.example.lld.tictactoe.model.Board;
import org.example.lld.tictactoe.model.Player;

public interface WinningStrategy {
    boolean isWinningMove(Board board, Player player);
}
