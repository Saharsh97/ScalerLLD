package main.java.Concurrency.semaphores.adder_subtractor_atomic;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// 1. we can use atomic integer for value.
// 2. change the updation in Adder Subtractor

public class Client {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        SharedValue v = new SharedValue();  // only 1 object made.

        Adder adderTask = new Adder(v);
        Subtractor subtractorTask = new Subtractor(v);
        // both AdderTask and SubtractorTask work on the same data.

        ExecutorService es = Executors.newCachedThreadPool();

        Future<Void> adderFuture = es.submit(adderTask);
        Future<Void> subtractorFuture = es.submit(subtractorTask);

        adderFuture.get();
        subtractorFuture.get();

        System.out.println(v.atomicInteger.get());

    }
}
