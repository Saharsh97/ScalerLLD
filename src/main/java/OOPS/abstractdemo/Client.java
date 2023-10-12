package main.java.OOPS.abstractdemo;

public class Client {
    public static void main(String[] args){
        Dog d = new Dog("good boi");
        d.sleep();
        d.makeSound();

        Whale w = new Whale();
        w.sleep();
        w.makeSound();

        Animal a = new Dog("besti");
        a.bark();

        w.bark();

    }
}
