package DesignPatterns.dynamicObserver.threads;

import DesignPatterns.dynamicObserver.WeatherData;
import DesignPatterns.dynamicObserver.devices.CurrentConditionsDisplay;

public class CurrentConditionsTask implements Runnable{
    WeatherData weatherData;

    public CurrentConditionsTask(WeatherData wd){
        weatherData = wd;
    }

    @Override
    public void run() {
        Long startTime = System.currentTimeMillis();    // t = 0
        CurrentConditionsDisplay currentConditionsDisplay = null;

        while (true) {
            Long currentTime = System.currentTimeMillis();  // t = 9

            if(currentTime - startTime > 9000 && currentConditionsDisplay == null){
                currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);
                currentConditionsDisplay.startListening();
            }

            if(currentTime - startTime > 33000){
                currentConditionsDisplay.stopListening();
                break;
            }
        }
    }
}
