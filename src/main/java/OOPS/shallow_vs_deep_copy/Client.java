package main.java.OOPS.shallow_vs_deep_copy;

public class Client {
    public static void main(String[] args){

//        Mentor m1 = new Mentor("Saharsh", 26);
//        Mentor m2 = m1;


        Student s1 = new Student(10, new int[]{0, 3, 5, 7, 9, 2});

        Student s2 = new Student();
        s2.x = s1.x;
        s2.x = 20;
        s2.y = s1.y;

        Student s3 = new Student();
        s3.x = s1.x;
        s3.y = new int[s1.y.length];
        for(int i = 0; i < s1.y.length; i++){
            s3.y [i] = s1.y[i];
        }
        System.out.println("debug statement");
        s2.y[3] = 10;
    }
}
