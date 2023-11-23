package DesignPatterns.dynamicObserver.threads;

import DesignPatterns.dynamicObserver.WeatherData;
import DesignPatterns.dynamicObserver.devices.CurrentConditionsDisplay;
import DesignPatterns.dynamicObserver.devices.ForecastDisplay;

public class ForecastThreadTask implements Runnable{
    WeatherData weatherData;

    public ForecastThreadTask(WeatherData wd){
        weatherData = wd;
    }

    @Override
    public void run() {
        Long startTime = System.currentTimeMillis();
        ForecastDisplay forecastDisplay = null;
        while(true){
            Long currentTime = System.currentTimeMillis();

            if(currentTime - startTime > 2000 && forecastDisplay == null){
                forecastDisplay = new ForecastDisplay(weatherData);
                forecastDisplay.startListening();
            }

            if(currentTime - startTime > 27000){
                forecastDisplay.stopListening();
                break;
            }
        }
    }
}
