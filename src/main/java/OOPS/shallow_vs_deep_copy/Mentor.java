package main.java.OOPS.shallow_vs_deep_copy;


import main.java.OOPS.static_examples.Rectangle;

public class Mentor {
    public final String name;
    public final int id;

    Mentor(String name, int age){
        this.name = name;
        this.id = age;
    }

    final void sampleFn(String name){
        System.out.println(this.name + " hello " + name);
        System.out.println(Rectangle.name);
    }
}
