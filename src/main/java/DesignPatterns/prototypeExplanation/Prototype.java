package main.java.DesignPatterns.prototypeExplanation;

// dont you think, this is a very general Prototype, not just for Student.
// so the clone() return type should be?

public interface Prototype<T> {
    T clone();
}
