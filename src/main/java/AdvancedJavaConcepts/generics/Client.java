package main.java.AdvancedJavaConcepts.generics;

import main.java.OOPS.accessmodifiers.Student;

// 3. you were using generics. You have not given any datatype, I will think of it as Object.
// The moment I give String, it will work fine.

// 6. add the following methods here.
// String x = GenericMethods.doSomething("Saharsh");    works fine.
// Long x = GenericMethods.doSomething("Saharsh");      error.

public class Client {
    public static void main(String[] args) {


        String x = GenericMethods.doSomething("Saharsh");

        GenericMethods<String, Integer> gMethods1 = new GenericMethods<>();
        GenericMethods<Double, Student> gMethods2 = new GenericMethods<>();

        GenericMethods defaultMethods = new GenericMethods(); // can write this. Java 5.
    }
}
