package main.java.AdvancedJavaConcepts.generics;

// 1. why is T showing in Red?
// because generics are defined at class level.
// create example objects in main function.


// Generic Methods:::
// 2. will this work with static?
// static functions are loaded at class level. Meaning it does not require object of class to be made.
// But we define the datatype when we create an object.
// so it will not work with static! both are contradictory! show error in full screen.
// so we cannot define <T> at class level, that would mean an pbject would be required.

// 3. however, we can still use generics for methods only, and not for class!
// now when do we declare the <T> ?? when we call the Static function.
// note: <T> is not the return type!! return type is still void here.
// check main notes.

// 4. I want the return type to be same as the datatype of the given parameter. what should be done?

// 5. If I want to make sure the object could be of different data types, use another Variable at Class level : S
// can I put S in the static function definition.
// can also extend this.


public class GenericMethods<S, V> {
    S first;
    V second;
    public static <T> T doSomething(T name){
        return name;
    }

    public S getFirst(){
        return first;
    }

    public V getSecond(){
        return second;
    }
}
