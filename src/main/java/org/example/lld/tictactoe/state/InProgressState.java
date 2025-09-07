package org.example.lld.tictactoe.state;

import org.example.lld.tictactoe.enums.GameStatus;
import org.example.lld.tictactoe.enums.Symbol;
import org.example.lld.tictactoe.model.Board;
import org.example.lld.tictactoe.model.Game;
import org.example.lld.tictactoe.model.Player;

public class InProgressState implements GameState {

    @Override
    public void handleMove(Game game, Player player, int x, int y) {
        Board board = game.getBoard();
        board.increaseMoveCount();
        Symbol symbol = player.getSymbol();
        board.placeSymbol(x, y, symbol);
        boolean winningMove = game.isWinningMove(player);
        if (winningMove) {
            game.setWinner(player);
            game.setGameStatus(symbol.equals(Symbol.O) ? GameStatus.WINNER_O : GameStatus.WINNER_X);
            game.setCurrentState(new WinnerState());
            return;
        }
        if (board.isFull()) {
            game.setGameStatus(GameStatus.DRAW);
            game.setCurrentState(new DrawState());
            return;
        }
        game.switchPlayer();
    }
}
