package main.java.OOPS.abstractdemo;

public abstract class Animal {
    public String name;

    Animal(){}

    Animal(String givenName){
        name = givenName;
    }

    public void sleep(){
        System.out.println(name + " is sleeping");
    }

    abstract public void makeSound();

    abstract public void bark();
}
