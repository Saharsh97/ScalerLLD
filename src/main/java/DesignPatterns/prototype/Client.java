package main.java.DesignPatterns.prototype;

import java.util.ArrayList;
import java.util.List;

import static main.java.DesignPatterns.prototypeExplanation.Constants.APRIL_21_BATCH;

public class Client {

    public static void fillRegistry(StudentRegistry studentRegistry){
        Student april21Batch = new Student();
        april21Batch.setBatch("APRIL 21 BATCH");
        april21Batch.setBatchAveragePsp(80.0);

        studentRegistry.register("APRIL 21 BATCH", april21Batch);

        IntelligentStudent april21BatchIntelligentStudent = new IntelligentStudent();
        april21BatchIntelligentStudent.setBatch("APRIL 21 INTELLIGENT BATCH");
        april21BatchIntelligentStudent.setBatchAveragePsp(95.0);
        april21BatchIntelligentStudent.setIq(200);

        studentRegistry.register("APRIL 21 BATCH INTELLIGENT STUDENTS", april21BatchIntelligentStudent);
    }

    public static void main(String[] args) {
        StudentRegistry studentRegistry = new StudentRegistry();
        fillRegistry(studentRegistry);

        List<Student> april21BatchStudents =  getAprilBatchStudents(studentRegistry);
        List<IntelligentStudent> april21IntelligentStudents = getAprilBatchIntelligentStudents(studentRegistry);
        System.out.println("debug");
    }

    private static List<Student> getAprilBatchStudents(StudentRegistry studentRegistry){
        Student sid = studentRegistry.get("APRIL 21 BATCH").clone();
        sid.setName("Siddarth");
        sid.setAge(30);
        sid.setPsp(90);

        Student mohit = studentRegistry.get("APRIL 21 BATCH").clone();
        mohit.setName("Mohit");
        mohit.setAge(28);
        mohit.setPsp(88);

        Student rahul = studentRegistry.get("APRIL 21 BATCH").clone();
        rahul.setName("Rahul");
        rahul.setAge(25);
        rahul.setPsp(80);

        List<Student> students = new ArrayList<>();
        students.add(sid);
        students.add(mohit);
        students.add(rahul);

        return students;
    }

    private static List<IntelligentStudent> getAprilBatchIntelligentStudents(StudentRegistry studentRegistry){
        IntelligentStudent rajat = (IntelligentStudent) studentRegistry.get("APRIL 21 BATCH INTELLIGENT STUDENTS").clone();
        rajat.setName("Rajat");
        rajat.setAge(30);
        rajat.setPsp(98);

        IntelligentStudent vijay = (IntelligentStudent) studentRegistry.get("APRIL 21 BATCH INTELLIGENT STUDENTS").clone();
        vijay.setName("Vijay");
        vijay.setAge(28);
        vijay.setPsp(96);


        IntelligentStudent shiva = (IntelligentStudent) studentRegistry.get("APRIL 21 BATCH INTELLIGENT STUDENTS").clone();
        shiva.setName("Shiva");
        shiva.setAge(25);
        shiva.setPsp(99);
        shiva.setIq(210);

        List<IntelligentStudent> students = new ArrayList<>();
        students.add(rajat);
        students.add(vijay);
        students.add(shiva);

        return students;
    }
}
