package DesignPatterns.dynamicObserver.devices;

import DesignPatterns.dynamicObserver.Observer;
import DesignPatterns.dynamicObserver.WeatherData;

public class StatisticsDisplay implements Observer {
    WeatherData wd;

    public StatisticsDisplay(WeatherData w){
        this.wd = w;
    }

    @Override
    public void update(double temp, double humidity, double pressure) {
        double formula = temp + (humidity/20) + pressure*10;
        System.out.println("SD: some average formula of weather " + formula);
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
