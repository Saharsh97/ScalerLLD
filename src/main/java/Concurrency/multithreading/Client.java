package main.java.Concurrency.multithreading;

public class Client {
    public static void main(String[] args) {
        HelloWorldPrinter x = new HelloWorldPrinter();
        Thread t = new Thread(x);
        t.start();
        System.out.println("MAIN FUNCTION, thread : " + Thread.currentThread().getName());
    }
}
