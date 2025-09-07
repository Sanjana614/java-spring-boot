package org.example.lld.tictactoe.state;

import org.example.lld.tictactoe.model.Game;
import org.example.lld.tictactoe.model.Player;

public interface GameState {
    void handleMove(Game game, Player player, int x, int y);
}
