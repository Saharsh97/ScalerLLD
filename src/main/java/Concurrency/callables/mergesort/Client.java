package main.java.Concurrency.callables.mergesort;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Client {
    // at 7:55
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Integer> arrayToSort = Arrays.asList(8, 1, 6, 2, 3, 9, 7, 5);
        ExecutorService es = Executors.newCachedThreadPool();
        // create task
        Sorter x = new Sorter(arrayToSort, es);
        // submit to ThreadPool
        Future<List<Integer>> sortedArrayFuture = es.submit(x);
        List<Integer> sortedArray = sortedArrayFuture.get();

        for(Integer number : sortedArray){
            System.out.print(number + " ");
        }
        // summarize here. explain the main function.
        // 8:00

        // debugger notes:
        // is there a single pool created? why are multiple pools being made?
        // go to pool 1 thread 1 Sorter line. It has complete data. it will create two new threads.
        // go to pool 2 thread 1 and thread 2

        // do you think making too many pools will also have an overhead??
        // so why not use only 1 pool!
        // pass ExecutorService in constructor. This creates many references, to the exact same pool
        // 8:05.

        // is merge sort using threads faster?
        // not much for smaller arrays, but for larger arrays, it will make a difference.
        // make a timer code to compare.

        // break at 8:10. till 8:20 max
    }
}
