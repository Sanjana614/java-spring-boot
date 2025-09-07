package org.example.lld.tictactoe;

import org.example.lld.tictactoe.model.Game;
import org.example.lld.tictactoe.model.Player;
import org.example.lld.tictactoe.observer.Scoreboard;

import java.util.Objects;

public class TicTacToeSystem {
    private static volatile TicTacToeSystem instance;
    private Game game;
    private Scoreboard scoreboard;

    public TicTacToeSystem() {
        this.scoreboard = new Scoreboard();
    }

    public static TicTacToeSystem getInstance() {
        if (Objects.isNull(instance)) {
            synchronized (TicTacToeSystem.class) {
                if (Objects.isNull(instance ))
                    instance = new TicTacToeSystem();
            }
        }
        return instance;
    }

    public void createGame(Player player1, Player player2) {
        this.game = new Game(player1, player2);
        this.game.addObserver(this.scoreboard);
    }

    public void makeMove(Player player, int x, int y) {
        if (Objects.isNull(game)) {
            System.out.println("No game started. Please create a game first.");
            return;
        }
        this.game.makeMove(player, x, y);
    }

    public void printBoard() {
        game.getBoard().printBoard();
    }

    public void printScoreBoard() {
        scoreboard.printScoreboard();
    }
}
