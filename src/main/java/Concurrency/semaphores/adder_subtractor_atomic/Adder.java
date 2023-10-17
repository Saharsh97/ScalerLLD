package main.java.Concurrency.semaphores.adder_subtractor_atomic;

import java.util.concurrent.Callable;
import java.util.concurrent.locks.Lock;

public class Adder implements Callable<Void> {
    private SharedValue v;

    Adder(SharedValue x){
        v = x;
    }

    @Override
    public Void call() throws Exception {
        for(int i = 1; i <= 50000; i++){
            v.atomicInteger.addAndGet(i);
        }
         return null;
    }
}
