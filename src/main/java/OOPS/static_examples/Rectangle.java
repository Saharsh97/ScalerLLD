package main.java.OOPS.static_examples;

public class Rectangle implements ShapeInterface{
    public static String name = "RECTANGLE";
    public int width;
    public int length;

    @Override
    public double area() {
        return length * width;
    }

    @Override
    public double perimeter() {
        return 2 * (length + width);
    }

    public static void intro(){
        System.out.println("hello I am " + name);
    }

    public void updateNameAttribute(String str){
        name = str;
    }
}
