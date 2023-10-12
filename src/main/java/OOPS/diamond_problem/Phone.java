package main.java.OOPS.diamond_problem;

//public class Phone implements TVInterface, LaptopInterface{
//    public String name;
//
//    public void display(){
//        System.out.println("this is phone display");
//    }
//}

public class Phone extends TV{
    public String name;

    public void display(){
        System.out.println("this is phone display");
    }

    public void model(){
        System.out.println("");
    }
}

// Animal a = new Dog()
// Laptop l = new phone();
// Phone p = new phone();

// l.display(); -> this is phone display
// p.display(); -> this is phone display
