package org.example.pattern.observer.subject;

import org.example.pattern.observer.observer.Observer;

import java.util.HashSet;
import java.util.Set;

public class WeatherStation implements Subject {
    private String weather;
    Set<Observer> observers = new HashSet<>();

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void setWeather(String weather) {
        this.weather = weather;
        notifyObserver(weather);
    }

    @Override
    public void notifyObserver(String weather) {
        for (Observer observer : observers) {
            observer.update(weather);
        }
    }
}
