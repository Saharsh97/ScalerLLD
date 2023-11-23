package DesignPatterns.observer;

import DesignPatterns.observer.devices.CurrentConditionsDisplay;
import DesignPatterns.observer.devices.ForecastDisplay;
import DesignPatterns.observer.devices.StatisticsDisplay;

public class WeatherStation {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();

        CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);
        StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
        ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);

        weatherData.setMeasurements(28.5, 80, 2);
        weatherData.setMeasurements(29, 81, 2.1);

        weatherData.removeObserver(forecastDisplay);

        weatherData.setMeasurements(27, 82, 2.2);

        weatherData.removeObserver(statisticsDisplay);

        weatherData.setMeasurements(29.5, 79, 2);

    }
}
