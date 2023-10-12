package main.java.Concurrency.callables.scaler_mergesort;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class Sorter implements Callable<List<Integer>> {
    List<Integer> arrayToSort;
    ExecutorService es;

    Sorter(List<Integer> givenArray, ExecutorService passedExecutorService){
        arrayToSort = givenArray;
        es = passedExecutorService;
    }

    @Override
    public List<Integer> call() throws Exception {
        if(arrayToSort.size() <= 1){
            return arrayToSort;
        }

        int size = arrayToSort.size();
        int mid = size/2;
        List<Integer> leftArray = new ArrayList<>();
        for(int i = 0; i < mid; i++){
            leftArray.add(arrayToSort.get(i));
        }
        List<Integer> rightArray = new ArrayList<>();
        for(int i = mid; i < size; i++){
            rightArray.add(arrayToSort.get(i));
        }

        // assign the leftArray and rightArray to threads!
        Sorter leftSorter = new Sorter(leftArray, es);
        Sorter rightSorter = new Sorter(rightArray, es);

        Future<List<Integer>> leftArrayFuture =  es.submit(leftSorter);
        Future<List<Integer>> rightArrayFuture = es.submit(rightSorter);

        // I have just given the task to two different people.
        // those people have given me a box (Future).
        // They have promised me, they will fill this box, the moment they are done sorting the array.

        // wait for the task to complete.
        List<Integer> leftSortedArray = leftArrayFuture.get();
        List<Integer> rightSortedArray = rightArrayFuture.get();

        int i = 0;
        int j = 0;
        List<Integer> mergedSortedArray = new ArrayList<>();
        while(i < leftSortedArray.size() && j < rightSortedArray.size()){
            int leftValue = leftSortedArray.get(i);
            int rightValue = rightSortedArray.get(j);

            if(leftValue < rightValue){
                mergedSortedArray.add(leftValue);
                i++;
            } else {
                mergedSortedArray.add(rightValue);
                j++;
            }
        }

        while(i < leftSortedArray.size()){
            int leftValue = leftSortedArray.get(i);
            mergedSortedArray.add(leftValue);
            i++;
        }

        while(j < rightSortedArray.size()){
            int rightValue = rightSortedArray.get(j);
            mergedSortedArray.add(rightValue);
            j++;
        }

        return mergedSortedArray;
    }
}
