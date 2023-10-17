package main.java.Concurrency.semaphores.producer_consumer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

// 1. will I have one semaphores? each semaphore for producer and consumer.
// 2. initial value of semaphores?
// Producer will acquire producerSemaphore for executing. Once done, it will release consumerSemaphore.
// Consumer will acquire consumerSemaphore for executing. Once done, it will release producerSemaphore.
// 3. Now the condition on producer loop is not needed.
// The count of producerSemaphore automatically means there are the available slots.
// The count of consumerSemaphore automatically means there are the available items.
// same values in output, CPU is very fast.

// 4. 7:55 : Thread sleep (10). This will make concurrency issue in list more pronounced.
// 5. concurrent list
// similar concurrent data structures are there, to handle data updates by multiple threads.

public class Client {
    public static void main(String[] args) {
        ExecutorService es = Executors.newCachedThreadPool();

        Store store = new Store(5);

        Semaphore producerSemaphore = new Semaphore(5);
        Semaphore consumerSemaphore = new Semaphore(0);

        // 8 producers, 20 consumers
        for(int i = 0; i < 8; i++){
            Producer p = new Producer(store, producerSemaphore, consumerSemaphore);
            es.execute(p);
        }
        for(int i = 0; i < 20; i++){
            Consumer c = new Consumer(store, producerSemaphore, consumerSemaphore);
            es.execute(c);
        }
    }
}
