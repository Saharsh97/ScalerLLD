package main.java.Concurrency.callables.adder_subtractor;

import java.util.concurrent.Callable;

public class Adder implements Callable<Void> {
    private SharedValue v;

    Adder(SharedValue x){
        v = x;
    }

    @Override
    public Void call() throws Exception {
        for(int i = 1; i <= 5000; i++){
            v.value += i;
        }
         return null;
    }
}
