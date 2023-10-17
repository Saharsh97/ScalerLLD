package main.java.Concurrency.semaphores.adder_subtractor_atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class SharedValue {
    public AtomicInteger atomicInteger = new AtomicInteger(0);
}
