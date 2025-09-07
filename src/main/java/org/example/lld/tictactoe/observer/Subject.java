package org.example.lld.tictactoe.observer;

public interface Subject {

    void addObserver(GameObserver gameObserver);

    void removeObserver(GameObserver gameObserver);

    void notifyObservers();
}
