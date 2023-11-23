package DesignPatterns.observer.devices;

import DesignPatterns.observer.Observer;
import DesignPatterns.observer.WeatherData;

public class CurrentConditionsDisplay implements Observer {
    WeatherData wd;

    public CurrentConditionsDisplay(WeatherData w){
        this.wd = w;
        wd.registerObserver(this);
    }

    @Override
    public void update(double temp, double humidity, double pressure) {
        System.out.println("current conditions are temp: " + temp + ", humidity: " + humidity + ", pressure: " + pressure);
    }
}
