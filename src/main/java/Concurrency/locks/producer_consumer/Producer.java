package main.java.Concurrency.locks.producer_consumer;

// 1. anything to return from thread?
// 2. what will we do in producer? It will work on a store object, given to us by the main function

public class Producer implements Runnable{

    private Store store;

    Producer(Store givenStore){
        store = givenStore;
    }

    @Override
    public void run() {
        while(true){
            synchronized (store) {
                if (store.getItems().size() < store.getMaxSize()) {
                    store.addItems();
                }
            }
        }
    }
}
