package DesignPatterns.dynamicObserver;

public interface Observer {
    void update(double temp, double humidity, double pressure);
    void startListening();
    void stopListening();
}
