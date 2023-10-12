package main.java.Concurrency.multithreading;

public class AnotherClient {
    public static void main(String[] args) {
        for(int i = 1; i <= 1000000; i++){
            NumberPrinter x = new NumberPrinter(i);
            Thread t = new Thread(x);
            t.start();
        }
        // break till 8:55
    }
}
