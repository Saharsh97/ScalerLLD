package main.java.Concurrency.multithreading;

// 5. NumberPrinter
public class NumberPrinter implements Runnable{
    private int noToPrint;

    NumberPrinter(int value){
        noToPrint = value;
    }

    public void run(){
        System.out.println("Number : " + noToPrint + " Thread : " + Thread.currentThread().getName());
    }
}
