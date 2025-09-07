package org.example.lld.tictactoe.observer;

import org.example.lld.tictactoe.model.Game;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

public class Scoreboard implements GameObserver {
    private final Map<String, Integer> scores;

    public Scoreboard() {
        this.scores = new ConcurrentHashMap<>();
    }

    @Override
    public void update(Game game) {
        if (Objects.isNull(game.getWinner())) {
            return;
        }
        String name = game.getWinner().getName();
        scores.put(name, scores.getOrDefault(name, 0) + 1);
        System.out.printf("[Scoreboard] %s wins! Their new score is %d.%n", name, scores.get(name));
    }

    public void printScoreboard() {
        scores.forEach((name, score) -> {
            System.out.println("Name: " + name + " | Score: " + score);
        });
    }
}
