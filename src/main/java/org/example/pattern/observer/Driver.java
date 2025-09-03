package org.example.pattern.observer;

import org.example.pattern.observer.observer.MobileDisplay;
import org.example.pattern.observer.observer.TVDisplay;
import org.example.pattern.observer.subject.WeatherStation;

public class Driver {
    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();

        MobileDisplay mobileDisplay = new MobileDisplay();
        TVDisplay tvDisplay = new TVDisplay();

        weatherStation.addObserver(mobileDisplay);
        weatherStation.addObserver(tvDisplay);

        weatherStation.setWeather("Summer");

        weatherStation.removeObserver(tvDisplay);

        weatherStation.setWeather("Winter");
    }
}
