package main.java.Concurrency.locks.producer_consumer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Producer Consumer
// before running, confirm all classes are understood.
// run the code, show error.
// go to notes, explain the scenario for both producers and consumers.
// all of them allowed to enter, all of them will produce.
// all of them allowed to enter, all of them will remove.
// how to remove them?
// add locks -> lets say we have synchronize

// add synchronize on producer and consumers.
// now it will never stop. previously it stopped.

// this is working fine. But is this a good of making this work?
// this is the most horrible way for a producer/consumer to work.



public class Client {
    public static void main(String[] args) {
        ExecutorService es = Executors.newCachedThreadPool();

        Store store = new Store(5);

        // 8 producers, 20 consumers
        for(int i = 0; i < 8; i++){
            Producer p = new Producer(store);
            es.execute(p);
        }
        for(int i = 0; i < 20; i++){
            Consumer c = new Consumer(store);
            es.execute(c);
        }
    }
}
