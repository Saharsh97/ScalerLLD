package main.java.Concurrency.semaphores.producer_consumer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;

public class Store {
    private int maxSize;
    private ConcurrentLinkedDeque<Object> items;

    Store(int maxSize){
        this.maxSize = maxSize;
        items = new ConcurrentLinkedDeque<>();
    }

    public int getMaxSize() {
        return maxSize;
    }

    public ConcurrentLinkedDeque<Object> getItems() {
        return items;
    }

    public void addItems(){
        this.items.addLast(new Object());
        System.out.println("add items, current size " + this.items.size());
    }

    public void removeItems(){
        // 4. This operation of remove() is not a 1 step process.
        // just like value += i is a 3 step process. list.remove() could be a 10 or 20 step process.
        // Lets say, there are 5 items, and its possible 2 consumers can enter this function.
        // both will see list.size as 5.
        this.items.removeLast();
        // list.remove(4). This works.
        // list.remove(4). This will be exception.
        System.out.println("remove items, current size " + this.items.size());
    }
}
