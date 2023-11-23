package DesignPatterns.observer.devices;

import DesignPatterns.observer.Observer;
import DesignPatterns.observer.WeatherData;

public class ForecastDisplay implements Observer {
    WeatherData wd;

    public ForecastDisplay(WeatherData w){
        this.wd = w;
        wd.registerObserver(this);
    }

    @Override
    public void update(double temp, double humidity, double pressure) {
        if(humidity > 80){
            System.out.println("its about rain");
        }
        else if(humidity < 80){
            System.out.println("its dry weather");
        }
        else {
            System.out.println("this is bangalore weather");
        }
        System.out.println();
    }
}
