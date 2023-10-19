package main.java.AdvancedJavaConcepts.session;

import java.util.List;

public class MyGeneric<S> {

    public static <T> void doSomething(T parameter){
        System.out.println(parameter);
    }

    public void saySomething(S param){
        System.out.println(param + " saying something");
    }

    public <E, R> R doExtra(E param, R secondParam, S thirdParam){
        System.out.println(param + " saying something");
        return secondParam;
    }


}
// break till 8:42.
