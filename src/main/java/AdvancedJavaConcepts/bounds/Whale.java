package main.java.AdvancedJavaConcepts.bounds;

import main.java.OOPS.interfacesdemo.Mammals;

public class Whale extends Animal {
    public String type;

    Whale(String name, String type){
        super(name);
        this.type = type;
    }

    public void swimmingDeep(){
        System.out.println("whale is swimming");
    }
}
