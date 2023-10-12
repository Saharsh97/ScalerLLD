package main.java.Concurrency.callables.mergesort;

import java.util.concurrent.Callable;

public class Sleeper implements Callable<Void> {

    @Override
    public Void call() throws Exception {
        Thread.sleep(3000);
        String response = Thread.currentThread().getName() + " has completed";
        System.out.println(response);
        return null;
    }
}
