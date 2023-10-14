package main.java.Concurrency.locks.synchronized_methods;

import java.util.concurrent.Callable;

public class Adder implements Callable<Void> {
    private SharedValue v;

    Adder(SharedValue x){
        v = x;
    }

    @Override
    public Void call() throws Exception {
        for(int i = 1; i <= 500000; i++){
            v.incrementBy(i);
        }
        return null;
    }
}
