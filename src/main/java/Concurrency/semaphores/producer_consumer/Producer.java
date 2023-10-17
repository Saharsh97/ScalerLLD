package main.java.Concurrency.semaphores.producer_consumer;

// 1. anything to return from thread?
// 2. what will we do in producer? It will work on a store object, given to us by the main function

import java.util.concurrent.Semaphore;

public class Producer implements Runnable{

    private Store store;
    private Semaphore producerSemaphore;
    private Semaphore consumerSemaphore;

    Producer(Store givenStore, Semaphore givenProdSem, Semaphore givenConsSem){
        store = givenStore;
        producerSemaphore = givenProdSem;
        consumerSemaphore = givenConsSem;
    }

    @Override
    public void run() {
        while(true){
            try {
                producerSemaphore.acquire();
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            store.addItems();
            consumerSemaphore.release();
        }
    }
}
