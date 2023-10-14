package main.java.Concurrency.locks.synchronized_methods;

import java.util.concurrent.Callable;

public class  Subtractor implements Callable<Void> {
    private SharedValue v;

    Subtractor(SharedValue x){
        v = x;
    }

    @Override
    public Void call() throws Exception {
        for(int i = 1; i <= 500000; i++){
            v.decrementBy(i);
        }
        return null;
    }
}
