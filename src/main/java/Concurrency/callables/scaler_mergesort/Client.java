package main.java.Concurrency.callables.scaler_mergesort;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Client {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Integer> array = Arrays.asList(8, 1, 6, 2, 3, 9, 7, 5);

        ExecutorService es = Executors.newCachedThreadPool();

        Sorter x = new Sorter(array, es);

        Future<List<Integer>> listFuture = es.submit(x);

        List<Integer> sortedArray = listFuture.get();
        for(Integer number : sortedArray){
            System.out.print(number + " ");
        }
        // break 9 AM.
    }
}
