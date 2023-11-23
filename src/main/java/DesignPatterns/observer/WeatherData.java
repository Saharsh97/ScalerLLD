package DesignPatterns.observer;

import java.util.ArrayList;
import java.util.List;

public class WeatherData implements Subject{    // this is the Publisher
    double temp;
    double humidity;
    double pressure;

    List<Observer> observerList = new ArrayList<>();

    @Override
    public void registerObserver(Observer ob) {
        observerList.add(ob);
    }

    @Override
    public void removeObserver(Observer ob) {
        observerList.remove(ob);
    }

    @Override
    public void notifyObservers() {
        for(Observer ob: observerList){
            ob.update(temp, humidity, pressure);
        }
    }

    public void setMeasurements(double t, double h, double p){
        this.temp = t;
        this.humidity = h;
        this.pressure = p;

        notifyObservers();
        System.out.println();
    }
}
