package main.java.OOPS.accessmodifiers;

public class Client {
    public static void main(String[] args){
        Student s1 = new Student("Naman", 123, 30, "scaler.com");
    }

    void doSomethingOnStudent(Student temp){
        temp.name = "Rohit";
        temp.age = 30;
        temp = null;
    }
}
