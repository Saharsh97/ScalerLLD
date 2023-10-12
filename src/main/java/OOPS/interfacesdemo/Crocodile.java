package main.java.OOPS.interfacesdemo;

public class Crocodile extends Reptile implements Runner, Swimmer{
    public void run(){
        System.out.println("crocodile is running on water lmao");
    }

    public void swim(){
        System.out.println("this scary boi is swimming");
    }

    public void sprint(){
        System.out.println("doggo running very fast");
    }
}
