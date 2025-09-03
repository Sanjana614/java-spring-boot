package org.example.pattern.observer.subject;

import org.example.pattern.observer.observer.Observer;

public interface Subject {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObserver(String weather);
}
