package main.java.OOPS.constructors;


import main.java.OOPS.accessmodifiers.Mentee;
import main.java.OOPS.accessmodifiers.Student;

public class AnotherClient {
    public static void main(String[] args){
        Student s1 = new Student();
        s1.name = "s1 student";
//        s1.age = 20;

        Mentee m1 = new Mentee();
        m1.name = "m1 student";
//        m1.age = 25;

        Buddy b1 = new Buddy();
        b1.name = "b1 student";
//        b1.age = 30;
    }

    void doSomething(){
        Student s1 = new Student();
        s1.name = "s1 student";
    }
}
