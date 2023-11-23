package DesignPatterns.dynamicObserver.devices;

import DesignPatterns.dynamicObserver.Observer;
import DesignPatterns.dynamicObserver.WeatherData;

public class ForecastDisplay implements Observer {
    WeatherData wd;

    public ForecastDisplay(WeatherData w){
        this.wd = w;
    }

    @Override
    public void update(double temp, double humidity, double pressure) {
        System.out.print("FD: ");
        if(humidity > 80){
            System.out.println("its about rain");
        }
        else if(humidity < 80){
            System.out.println("its dry weather");
        }
        else {
            System.out.println("this is bangalore weather");
        }
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
