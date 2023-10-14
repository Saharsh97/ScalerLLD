package main.java.Concurrency.locks.synchronized_code;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// synchronized keyword
// 1. use synchronized. takes a lock on the memory location.
// 2. without sync in subtractor, it is not asking for a lock. It can read it right away!
// if sub used synchronized, then it would have waited. One by One would be possible.
// adder has asked for a lock, but subtractor is not even waiting... then it doesn't make sense to have a sync in Adder.

public class Client {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        SharedValue v = new SharedValue();  // only 1 object made.

        Adder adderTask = new Adder(v);
        Subtractor subtractorTask = new Subtractor(v);

        ExecutorService es = Executors.newCachedThreadPool();

        Future<Void> adderFuture = es.submit(adderTask);
        Future<Void> subtractorFuture = es.submit(subtractorTask);

        adderFuture.get();
        subtractorFuture.get();

        System.out.println(v.value);

    }
}
