package main.java.Concurrency.locks.producer_consumer;

import java.util.ArrayList;
import java.util.List;

public class Store {
    private int maxSize;
    private List<Object> items;

    Store(int maxSize){
        this.maxSize = maxSize;
        items = new ArrayList<>();
    }

    public int getMaxSize() {
        return maxSize;
    }

    public List<Object> getItems() {
        return items;
    }

    public void addItems(){
        this.items.add(new Object());
        System.out.println("add items, current size " + this.items.size());
    }

    public void removeItems(){
        this.items.remove(this.items.size() - 1);
        System.out.println("remove items, current size " + this.items.size());
    }
}
