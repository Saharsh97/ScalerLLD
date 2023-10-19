package main.java.AdvancedJavaConcepts.bounds;;

public class Animal extends Species{
    public String name;

    Animal(String name){
        this.name = name;
    }

    public void eat(){
        System.out.println(name + " is eating");
    }

    public void sleep(){
        System.out.println(name + " is sleeping");
    }
}
