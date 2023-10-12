package main.java.OOPS.static_examples;

public class Circle implements ShapeInterface{
    public static String name = "CIRCLE";
    public static final double PI = 3.14;
    int radius = 0;

    Circle(int radiusOfCircle){
        this.radius = radiusOfCircle;
    }

    @Override
    public double area() {
        return PI * radius * radius;
    }

    @Override
    public double perimeter() {
        return 2 * PI * radius;
    }
}
