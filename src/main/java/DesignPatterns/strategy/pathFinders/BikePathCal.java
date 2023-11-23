package DesignPatterns.strategy.pathFinders;

public class BikePathCal implements PathCalculator {
    private static BikePathCal INSTANCE = new BikePathCal();
    private BikePathCal(){}
    public static BikePathCal getInstance(){
        return INSTANCE;
    }
    @Override
    public void findPath(String from, String to) {
        System.out.println("take the highway only");
    }
}
