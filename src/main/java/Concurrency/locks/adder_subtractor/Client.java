package main.java.Concurrency.locks.adder_subtractor;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// Adder Subtractor using Locks
// 1. give one lock to two tasks.
// 2. show print statements under lock => unordered output. sometimes adder print, sometimes sub print. reduce loop to 50.
// 3. take lock on whole for loop. what does this mean? This is sequential. not concurrent.
// 4. queue on the lock.

public class Client {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Lock lock = new ReentrantLock();
        SharedValue v = new SharedValue();  // only 1 object made.

        // we have made only one lock. Pass this same lock to the two tasks.
        // the threads will wait for lock to be free, and then begin their execution
        Adder adderTask = new Adder(v, lock);
        Subtractor subtractorTask = new Subtractor(v, lock);
        // both AdderTask and SubtractorTask work on the same data.

        ExecutorService es = Executors.newCachedThreadPool();

        Future<Void> adderFuture = es.submit(adderTask);
        Future<Void> subtractorFuture = es.submit(subtractorTask);

        adderFuture.get();
        subtractorFuture.get();

        System.out.println(v.value);

    }
}
