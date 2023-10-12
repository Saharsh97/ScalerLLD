package main.java.OOPS.accessmodifiers;

public class Student {
    public String name;
    private int phNo;
    protected int age;
    String emailId;

    // usage of 'this' keyword.
    // when to use 'this', when not to use 'this'.

    // Ultimately, we want Java to understand what we want to do.
    // Java should not feel confused at any statement.

    public Student(){

    }

    Student(String name, int phNo, int ageValue, String emailIdNew){
        this.name = name;
        // 1. class attribute name is assigned the passed name.
        // 2. passed name is assigned the class name attribute.
        this.phNo = phNo;
        age = ageValue;
        emailId = emailIdNew;
    }
}
