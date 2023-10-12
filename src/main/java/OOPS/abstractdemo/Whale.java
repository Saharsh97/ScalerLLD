package main.java.OOPS.abstractdemo;

import main.java.OOPS.abstractdemo.Animal;

public class Whale extends Animal {
    public String type;

    Whale(){
        super("bigg");
        type = "blue whale";
    }

    public void sleep(){
        System.out.println("floating through the water ");
    }

    public void makeSound(){
        System.out.println("muuuuuu");
    }

    public void bark(){
        System.out.println("muu bark");
    }
}
