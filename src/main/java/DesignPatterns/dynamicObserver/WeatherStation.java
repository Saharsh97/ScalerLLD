package DesignPatterns.dynamicObserver;

import DesignPatterns.dynamicObserver.threads.CurrentConditionsTask;
import DesignPatterns.dynamicObserver.threads.ForecastThreadTask;
import DesignPatterns.dynamicObserver.threads.StatisticsThreadTask;

public class WeatherStation {
    public static void main(String[] args) throws InterruptedException {
        WeatherData weatherData = new WeatherData();

        // 9 - 33
        CurrentConditionsTask currentConditionsTask = new CurrentConditionsTask(weatherData);
        Thread t1 = new Thread(currentConditionsTask);
        t1.start();

        // 2 - 27
        ForecastThreadTask forecastThreadTask = new ForecastThreadTask(weatherData);
        Thread t2 = new Thread(forecastThreadTask);
        t2.start();

        // 14 - 43
        StatisticsThreadTask statisticsThreadTask = new StatisticsThreadTask(weatherData);
        Thread t3 = new Thread(statisticsThreadTask);
        t3.start();

        double temperature = 25;
        double humidity = 75;
        double pressure = 2;

        int timer = 0;
        while(timer <= 60){
            System.out.println("setting new data at time " + timer + "s");
            weatherData.setMeasurements(temperature, humidity, pressure);
            System.out.println();

            temperature += 0.5;
            humidity += 1;
            pressure += 0.1;
            timer += 5;

            Thread.sleep(5*1000);
        }
    }
}
