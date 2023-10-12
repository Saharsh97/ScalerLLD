package main.java.OOPS.interfacesdemo;

public class Dog extends Mammals implements Runner, Swimmer  {
    public String breed;

    Dog(){
        name = "good doggo";
        breed = "Golden Retriever";
    }

    public void bark(){
        System.out.println("doggo is barking");
    }

    public void run(){
        System.out.println("doggo is running");
    }

    public void sprint(){
        System.out.println("doggo running very fast");
    }

    public void swim(){
        System.out.println("doggo is swimming");
    }
}
