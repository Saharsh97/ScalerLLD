package DesignPatterns.strategy.pathFinders;

public class CarPathCal implements PathCalculator{
    private static CarPathCal INSTANCE = new CarPathCal();
    private CarPathCal(){}
    public static CarPathCal getInstance(){
        return INSTANCE;
    }

    @Override
    public void findPath(String from, String to) {
        System.out.println("Take nearest highway from " + from);
        System.out.println("Take the next expressway");
        System.out.println("get out to nearest highway at " + to);
    }
}
