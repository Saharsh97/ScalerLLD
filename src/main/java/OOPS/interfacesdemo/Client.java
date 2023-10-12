package main.java.OOPS.interfacesdemo;;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args){
        Dog d = new Dog();
        System.out.println("dog name is " + d.name);
        System.out.println("dog breed is " + d.breed);
        System.out.println("dog can give birth? " + d.canGiveBirth);
        d.bark();
        d.eat();
        d.sleep();
        d.run();
        d.swim();
        System.out.println();

        Whale w = new Whale();
        System.out.println("whale name is " + w.name);
        System.out.println("whale can give birth? " + d.canGiveBirth);

        System.out.println();

        Pigeon p = new Pigeon();

        Ostrich o = new Ostrich();

        Crocodile c = new Crocodile();

        System.out.println("make all animal eat and sleep...");
        List<Animal> animalList = new ArrayList<>();
        animalList.add(d);
        animalList.add(w);
        animalList.add(p);
        animalList.add(o);
        animalList.add(c);

        for(Animal x: animalList){
            x.sleep();
        }
        System.out.println();

        System.out.println("those animals that can run, make them run by calling run()");
        List<Runner> runnerList = new ArrayList<>();
        runnerList.add(d);
        runnerList.add(o);
        runnerList.add(c);

        for(Runner x: runnerList){
            x.run();
        }
        System.out.println();

        System.out.println("those animals that can swim, make them swim by calling swim()");
        List<Swimmer> swimmers = new ArrayList<>();
        swimmers.add(d);
        swimmers.add(c);

        for(Swimmer x: swimmers){
            x.swim();
        }
        System.out.println();

        SimpleInterest si = new SimpleInterest(100, 7);
        si.computeInterestAmount();
        CompundInterest ci = new CompundInterest();


        Animal a = new Dog();

        System.out.println(Runner.bigName);
        Runner r = new Dog();
    }
}
