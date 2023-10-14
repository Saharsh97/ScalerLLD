package main.java.Concurrency.locks.producer_consumer;


public class Consumer implements Runnable{

    private Store store;

    Consumer(Store givenStore){
        store = givenStore;
    }

    @Override
    public void run() {
        while (true){
            synchronized (store) {
                if (store.getItems().size() > 0) {
                    store.removeItems();
                }
            }
        }
    }
}
