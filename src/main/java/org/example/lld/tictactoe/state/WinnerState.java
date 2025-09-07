package org.example.lld.tictactoe.state;

import org.example.lld.tictactoe.model.Game;
import org.example.lld.tictactoe.model.Player;

public class WinnerState implements GameState {
    @Override
    public void handleMove(Game game, Player player, int x, int y) {
        System.out.println("Game already over. " + game.getWinner().getName() + " has won.");
    }
}
