package main.java.Concurrency.semaphores.producer_consumer;


import java.util.concurrent.Semaphore;

public class Consumer implements Runnable{

    private Store store;
    private Semaphore producerSemaphore;
    private Semaphore consumerSemaphore;

    Consumer(Store givenStore, Semaphore givenProdSem, Semaphore givenConsSem){
        store = givenStore;
        producerSemaphore = givenProdSem;
        consumerSemaphore = givenConsSem;
    }

    @Override
    public void run() {
        while (true){
            try {
                consumerSemaphore.acquire();
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            store.removeItems();
            producerSemaphore.release();
        }
    }
}
