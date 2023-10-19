package main.java.OOPS.interfacesdemo;

import main.java.OOPS.accessmodifiers.Student;

;

public class Animal {
    public String name;

    Object p1 = new Student();
    Object p2 = new Integer(3);



    Object x;
    Integer k;
    String s = "Saharsh";
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
