package main.java.Concurrency.locks.synchronized_methods;


import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

// synchronized methods
// 1. we want to ensure the addition/subtraction happens via object method functions.
// so we can write functions in ShareValue class.
// Now we dont need to mention locks or synchronized explicitly.
// we define synchronize via method. Looking at the method I can realise this will be execute by only 1 thread at a time.

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
