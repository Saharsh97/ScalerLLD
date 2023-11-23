package DesignPatterns.observer;

public interface Subject {  // this could be Publisher, Provider, etc...
    void registerObserver(Observer ob);
    void removeObserver(Observer ob);
    void notifyObservers();
}
