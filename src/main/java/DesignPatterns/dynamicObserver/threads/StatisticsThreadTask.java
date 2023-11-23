package DesignPatterns.dynamicObserver.threads;

import DesignPatterns.dynamicObserver.WeatherData;
import DesignPatterns.dynamicObserver.devices.ForecastDisplay;
import DesignPatterns.dynamicObserver.devices.StatisticsDisplay;

public class StatisticsThreadTask implements Runnable{
    WeatherData weatherData;

    public StatisticsThreadTask(WeatherData wd){
        weatherData = wd;
    }

    @Override
    public void run() {
        Long startTime = System.currentTimeMillis();
        StatisticsDisplay statisticsDisplay = null;
        while(true){
            Long currentTime = System.currentTimeMillis();

            if(currentTime - startTime > 14000 && statisticsDisplay == null){
                statisticsDisplay = new StatisticsDisplay(weatherData);
                statisticsDisplay.startListening();
            }

            if(currentTime - startTime > 43000){
                statisticsDisplay.stopListening();
                break;
            }
        }
    }
}
