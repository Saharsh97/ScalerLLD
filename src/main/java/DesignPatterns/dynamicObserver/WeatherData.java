package DesignPatterns.dynamicObserver;

import java.util.ArrayList;
import java.util.List;

public class WeatherData implements Subject {
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
        if(observerList.size() == 0){
            System.out.println("No one is listening");
        }
        for(Observer ob: observerList){
            ob.update(temp, humidity, pressure);
        }
    }

    public void setMeasurements(double t, double h, double p){
        this.temp = t;
        this.humidity = h;
        this.pressure = p;

        notifyObservers();
    }
}
