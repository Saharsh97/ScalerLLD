package main.java.AdvancedJavaConcepts.bounds;

import main.java.OOPS.interfacesdemo.Mammals;
import main.java.OOPS.interfacesdemo.Runner;
import main.java.OOPS.interfacesdemo.Swimmer;

public class Dog extends Animal{
    public String breed;

    Dog(String name, String breed){
        super(name);
        this.breed = breed;
    }

    public void bark() {
        System.out.println("doggo is barking");
    }
}
