package DesignPatterns.strategy;

import DesignPatterns.strategy.pathFinders.BikePathCal;
import DesignPatterns.strategy.pathFinders.CarPathCal;
import DesignPatterns.strategy.pathFinders.PathCalculator;
import DesignPatterns.strategy.pathFinders.TrainPathCal;

public class PathFactory {
    CarPathCal carPathCalInstance = CarPathCal.getInstance();
    BikePathCal bikePathCalInstance = BikePathCal.getInstance();

    PathCalculator getPathCalByMode(String mode){
        if(mode.equals("CAR")){
            return carPathCalInstance;
        }
        if(mode.equals("BIKE")){
            return bikePathCalInstance;
        }
        if(mode.equals("TRAIN")){
            return new TrainPathCal();
        }
        return null;
    }
}
