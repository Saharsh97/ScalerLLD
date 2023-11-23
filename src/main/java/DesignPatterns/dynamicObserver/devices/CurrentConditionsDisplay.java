package DesignPatterns.dynamicObserver.devices;

import DesignPatterns.dynamicObserver.Observer;
import DesignPatterns.dynamicObserver.WeatherData;

public class CurrentConditionsDisplay implements Observer {
    WeatherData wd;

    public CurrentConditionsDisplay(WeatherData w){
        this.wd = w;
    }

    @Override
    public void update(double temp, double humidity, double pressure) {
        System.out.println("CCD: current conditions are temp: " + temp + ", humidity: " + humidity + ", pressure: " + pressure);
    }

    @Override
    public void startListening() {
        wd.registerObserver(this);
    }

    @Override
    public void stopListening() {
        wd.removeObserver(this);
    }
}
