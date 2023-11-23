package DesignPatterns.strategy;

import DesignPatterns.strategy.pathFinders.PathCalculator;

public class GoogleMaps {
    public void findPath(String from, String to, String mode){
        PathFactory pathFactory = new PathFactory();
        PathCalculator x = pathFactory.getPathCalByMode(mode);
        x.findPath(from, to);


        PathCalculator y = pathFactory.getPathCalByMode(mode);
        y.findPath(from, to);

    }
}
