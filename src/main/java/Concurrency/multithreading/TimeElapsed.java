package main.java.Concurrency.multithreading;

public class TimeElapsed implements Runnable{

    public void run(){
        int timesSlept = 0;
        while(true) {
            System.out.println("Time Elapsed : " + timesSlept);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            timesSlept++;
            if (timesSlept > 10){
                System.out.println("Time Elapsed thread has timedout out");
                break;
            }
        }
    }
}
