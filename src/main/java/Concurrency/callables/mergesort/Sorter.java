package main.java.Concurrency.callables.mergesort;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

// implement this class completely.
// 1. implements what?
// 2. return what data type?
// 3. the call() function will work on some data?
// 4. where will get this array. When the client makes an object of Sorter, it will supply this array.
// 5. should we directly start sorting? Or some basic condition we can add?
// 6. whats next? Find mid and create leftArray and rightArray.
// 7. whats next? Sort the leftArray and rightArray, using...?
// these are two tasks!
// how to deal with this? First make what? Object of the tasks.
// then use threads for each task.

public class Sorter implements Callable<List<Integer>> {
    private List<Integer> arrayToSort;
    ExecutorService executorService;

    Sorter(List<Integer> givenList, ExecutorService es){
        arrayToSort = givenList;
        executorService = es;
    }

    public List<Integer> call() throws Exception {
        if(arrayToSort.size() <= 1){
            return arrayToSort;
        }
        // 6.
        int size = arrayToSort.size();
        int mid = size / 2;
        List<Integer> leftArray = new ArrayList<>();
        List<Integer> rightArray = new ArrayList<>();

        for(int i = 0; i < mid; i++){
            leftArray.add(arrayToSort.get(i));
        }
        for(int i = mid; i < size; i++){
            rightArray.add(arrayToSort.get(i));
        }

        // 7.
//        ExecutorService es = Executors.newCachedThreadPool();

        // create tasks.
        Sorter leftArraySortingTask = new Sorter(leftArray, executorService);
        Sorter rightArraySortingTask = new Sorter(rightArray, executorService);

        // assign tasks to threads.
        // what did we do previously? use es.execute for Runnables.
        // es.execute takes a runnable. We have a different function for Callables.
//        es.submit(leftArraySortingTask);
//        es.submit(rightArraySortingTask);

        // are we receiving any data here??
        // as soon as I call this, will the data be ready??
        // So Java provides something called a Future.
        Future<List<Integer>> sortedLeftArrayFuture = executorService.submit(leftArraySortingTask);
        Future<List<Integer>> sortedRightArrayFuture = executorService.submit(rightArraySortingTask);
        // so what do you think future is? think about it logically.
        // submit says, I dont have the data right now. I cannot give it to you right now. 
        // why? because I am yet to be executed. Once I am fully executed, I will give you the data.
        // so for now, hold this box (like a future, like a promise), the moment I get the data, I will put it in this box!
        // then you can use my response as you wish.
        // the box that I give you is a promise, that I will fill the box.
        // in this function, the thread that executes this call(), will call es.submit(task) and go ahead! It doesnt wait specifically.

        // so I have got a box (a future), but am I waiting for it??
        // so I have to ensure that I am waiting for the two boxes to be filled, then I can go ahead??
        // to wait, futures provide a get function.
        List<Integer> leftSortedArray = sortedLeftArrayFuture.get();
        List<Integer> rightSortedArray = sortedRightArrayFuture.get();

        // once you have both the left and right sorted array, what do you have to do?
        // merge them

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

        // summarize here!
        return mergedSortedArray;
    }
}
