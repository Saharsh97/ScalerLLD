package main.java.Concurrency.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EfficientClientForThreads {
    public static void main(String[] args) throws InterruptedException {
        // 7. Thread pool
        ExecutorService es = Executors.newFixedThreadPool(10);
        for(int i = 1; i <= 1000000; i++){
            NumberPrinter x = new NumberPrinter(i);
            es.execute(x);
            // 1. push x to waiting queue.
            // the moment any of the 10 threads are available, x is picked from the queue.
        }
        // show that, each thread pool is used for completely different numbers. nothing sequential
        // do you have any thread with name more than 10??

        // it took 5-10 seconds
        // CPU usage was 40-50%.





        // 8. CPU Usage and efficiency
//        ExecutorService ex = Executors.newFixedThreadPool(10);
//        for(int i = 1; i <= 100; i++){
//            NumberPrinter x = new NumberPrinter(i);
//            ex.execute(x);
//        }
        // CPU spike only momentarily. CPU usage is at 30%.
        // Try to count the seconds in your mind

        // difference in time between with and without threadpool
//        for(int i = 1; i <= 1000000; i++){
//            NumberPrinter x = new NumberPrinter(i);
//            Thread t = new Thread(x);
//            t.start();
//        }
        // CPU usage now is at 150%.
        // time to complete is 70 seconds.
        // this is much slower, and taking up a lot of CPU!
        // in Practical scenarios, never make individual threads for all tasks! go with ThreadPool!

        // benefits of FixedThreadPool? Less CPU usage, and faster results. win-win.







        // 9. CachedThreadPool
//        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
//        // anything different you see here?
//        // will it make 100 threads for 1-100 printing?
//        for(int i = 1; i <= 1000000; i++){
//            NumberPrinter x = new NumberPrinter(i);
//            cachedThreadPool.execute(x);
//        }
        // do you have thread number 100? thread number 50?
        // It will only create a new thread if all threads are busy.
        // Otherwise it will reuse an idle thread.

//        for(int i = 1; i <= 1000000; i++){
//            NumberPrinter x = new NumberPrinter(i);
//            cachedThreadPool.execute(x);
//        }




        // 10. issue with threads?
        // are the threads working in a sequential manner?
        // threads execute randomly. we will take this up in the next class.




        // 11. work queue.
//        ExecutorService ex = Executors.newFixedThreadPool(10);
//        for(int i = 1; i <= 100; i++){
//            if(i == 80){
//                System.out.println("stop for debugging");
//            }
//            NumberPrinter x = new NumberPrinter(i);
//            ex.execute(x);
//        }
        // How many tasks have I created?
        // How many have completed?
        // How many are in the queue?
        // tasks pushed to queue sequentially. show output, those many have completed.
    }
}
