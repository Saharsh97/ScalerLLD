package main.java.OOPS.interfacesdemo;

public class Pigeon extends Bird implements Flyable{
    public String color;

    Pigeon(){
        super(true);
        color = "black";
    }

    public void fly(){
        System.out.println("bird is flying");
    }
}
