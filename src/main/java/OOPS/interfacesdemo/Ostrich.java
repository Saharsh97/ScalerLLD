package main.java.OOPS.interfacesdemo;

public class Ostrich extends Bird implements Runner{
    public double height;

    Ostrich(){
        super(false);
        height = 2.1;
    }

    public void run(){
        System.out.println("ostrich is running instead of flying");
    }
}
