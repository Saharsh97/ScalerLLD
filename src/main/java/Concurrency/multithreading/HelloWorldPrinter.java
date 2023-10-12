package main.java.Concurrency.multithreading;


public class HelloWorldPrinter implements Runnable {
    public void doSomething(){
        System.out.println("DO SOMETHING, Thread : " + Thread.currentThread().getName());
    }

    @Override
    public void run() {
        doSomething();
        System.out.println("HELLO WORLD, Thread : " + Thread.currentThread().getName());
    }
}
