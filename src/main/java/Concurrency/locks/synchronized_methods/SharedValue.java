package main.java.Concurrency.locks.synchronized_methods;

public class SharedValue {
    public int value = 0;

    public synchronized void incrementBy(int x){
        value += x;
    }

    public synchronized void decrementBy(int x){
        value -= x;
    }
}
