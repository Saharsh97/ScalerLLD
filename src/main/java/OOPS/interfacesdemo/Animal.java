package main.java.OOPS.interfacesdemo;;

public class Animal {
    public String name;

    Animal(){
        name = "SomeAnimalName";
    }

    public void eat(){
        System.out.println(name + " is eating");
    }

    public void sleep(){
        System.out.println(name + " is sleeping");
    }
}
