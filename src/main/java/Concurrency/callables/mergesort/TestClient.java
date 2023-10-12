package main.java.Concurrency.callables.mergesort;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestClient {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(10);

        Sleeper t0 = new Sleeper();
        Sleeper t1 = new Sleeper();

        Future<Void> future1 = es.submit(t0);
        Future<Void> future2 = es.submit(t1);
        System.out.println("Done submitted threads to ES");

        future1.get();
        future2.get();

        System.out.println("Main thread has finished");
    }
}
