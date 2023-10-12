package main.java.OOPS.abstractdemo;

public class Dog extends Animal {
    public String breed;

    Dog(String dogName){
        super(dogName);
        breed = "GR";
    }

    public void makeSound(){
        System.out.println("good boi noises.. bark");
    }

    public void bark(){
        System.out.println("dog bark");
    }
}
