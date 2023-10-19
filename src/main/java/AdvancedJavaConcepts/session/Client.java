package main.java.AdvancedJavaConcepts.session;


import main.java.OOPS.accessmodifiers.Student;

import java.util.HashMap;

public class Client {
    public static void main(String[] args) {

        MyGeneric.doSomething("Saharsh");

        Student st = new Student();
        MyGeneric.doSomething(st);

        MyGeneric<Integer> integerMyGeneric = new MyGeneric<>();
        integerMyGeneric.saySomething(50);
        integerMyGeneric.doExtra("Mohit", st, 100);

        HashMap<String, Integer> mp = new HashMap<>();
        mp.put("Saharsh", 10);
        Integer x = mp.get("Saharsh");
    }
}
