package main.java.DesignPatterns.builder;

public class Client {
    public static void main(String[] args) {
        Student st1 = Student.getBuilder()
                        .setAge(25)
                        .setName("Chaitanya")
                        .setGradYear(2020)
                        .build();

        System.out.println("works fine! " + st1.age);
    }
}
