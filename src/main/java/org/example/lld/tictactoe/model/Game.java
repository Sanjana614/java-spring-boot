package org.example.lld.tictactoe.model;

import org.example.lld.tictactoe.enums.GameStatus;
import org.example.lld.tictactoe.enums.Symbol;
import org.example.lld.tictactoe.observer.GameObserver;
import org.example.lld.tictactoe.observer.Subject;
import org.example.lld.tictactoe.state.GameState;
import org.example.lld.tictactoe.state.InProgressState;
import org.example.lld.tictactoe.strategy.*;

import java.util.ArrayList;
import java.util.List;

public class Game implements Subject {
    private final Board board;
    private final Player player1;
    private final Player player2;
    private Player winner;
    private Player currentPlayer;
    private GameStatus gameStatus;
    private GameState currentState;
    private final List<GameObserver> gameObservers = new ArrayList<>();
    private final List<WinningStrategy> winningStrategies;

    public Game(Player player1, Player player2) {
        this.board = new Board(3);
        this.player1 = player1;
        this.player2 = player2;
        this.currentPlayer = player1;
        this.gameStatus = GameStatus.IN_PROGRESS;
        this.winningStrategies = getWinningStrategies();
        this.currentState = new InProgressState();
    }

    @Override
    public void addObserver(GameObserver gameObserver) {
        this.gameObservers.add(gameObserver);
    }

    @Override
    public void removeObserver(GameObserver gameObserver) {
        this.gameObservers.remove(gameObserver);
    }

    @Override
    public void notifyObservers() {
        this.gameObservers.forEach(observer -> observer.update(this));
    }

    public void switchPlayer() {
        this.currentPlayer = (this.currentPlayer == player1) ? player2 : player1;
    }

    public boolean isWinningMove(Player player) {
        return winningStrategies.stream()
                .anyMatch(strategy -> strategy.isWinningMove(board, player));
    }

    public Board getBoard() {
        return this.board;
    }

    public Player getWinner() {
        return this.winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
        if (!GameStatus.IN_PROGRESS.equals(gameStatus)) {
            notifyObservers();
        }
    }

    public void setCurrentState(GameState currentState) {
        this.currentState = currentState;
    }

    public List<WinningStrategy> getWinningStrategies() {
        ArrayList<WinningStrategy> strategies = new ArrayList<>();
        strategies.add(new RowWinningStrategy());
        strategies.add(new ColumnWinningStrategy());
        strategies.add(new DiagonalWinningStrategy());
        return strategies;
    }

    public void makeMove(Player player, int x, int y) {
        int size = this.board.getSize();
        if (!currentPlayer.equals(player)) {
            System.out.println("Wrong player turn.");
            return;
        }
        if (x < 0 || x >= size || y < 0 || y >= size || !Symbol.EMPTY.equals(board.getSymbol(x,y))) {
            System.out.println("Invalid move.");
            return;
        }
        this.currentState.handleMove(this, player, x, y);
    }
}
