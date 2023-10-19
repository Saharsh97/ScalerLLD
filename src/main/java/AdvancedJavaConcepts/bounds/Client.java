package main.java.AdvancedJavaConcepts.bounds;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        Dog d1 = new Dog("good boi", "golden retriever");
        Dog d2 = new Dog("chonky boi", "labrador");

        Cat c1 = new Cat("tom");
        Cat c2 = new Cat("tommy");

        Bird b = new Bird("birdy", true);

        List<Animal> animals = new ArrayList<>();
        animals.add(d1);
        animals.add(d2);
        animals.add(c1);

        List<Dog> doggos = new ArrayList<>();
        doggos.add(d1);
        doggos.add(d2);

        List<Bird> birds = new ArrayList<>();
        birds.add(b);

        MyGeneric.doSomething(animals);
        System.out.println();

        MyGeneric.doSomething(doggos);
        System.out.println();

        Species sp = new Species();
        List<Species> manySpecies = new ArrayList<>();
        manySpecies.add(sp);

//        MyGeneric.doSomething(manySpecies);
    }
}
