package main.java.Concurrency.callables.scaler_mergesort;
import java.util.ArrayList;
import java.util.List;
public class SimpleMergeSort {
    private List<Integer> arrayToSort;

    SimpleMergeSort(List<Integer> givenList){
        arrayToSort = givenList;
    }

    public List<Integer> sort() throws Exception {
        if(arrayToSort.size() <= 1){
            return arrayToSort;
        }
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


        SimpleMergeSort leftMergeSort = new SimpleMergeSort(leftArray);
        SimpleMergeSort rightMergeSort = new SimpleMergeSort(rightArray);

        List<Integer> leftSortedArray = leftMergeSort.sort();
        List<Integer> rightSortedArray = rightMergeSort.sort();



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