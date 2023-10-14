package main.java.Concurrency.locks.synchronized_code;

import java.util.concurrent.Callable;
import java.util.concurrent.locks.Lock;

public class Adder implements Callable<Void> {
    private SharedValue v;

    Adder(SharedValue x){
        v = x;
    }

    @Override
    public Void call() throws Exception {
        for(int i = 1; i <= 500000; i++){
            synchronized (v) {
                v.value += i;
            }
        }
         return null;
    }
}
