//package main.java.DesignPatterns.prototypeExplanation;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static main.java.DesignPatterns.prototypeExplanation.Constants.APRIL_21_BATCH;
//import static main.java.DesignPatterns.prototypeExplanation.Constants.APRIL_21_BATCH_INTELLIGENT_STUDENTS;
//
//// 3. lets fill the Registry first, then work with client
//
//// 4. If I remove all getters from Student, how to allow IntelligentStudent to work.
//public class Client {
//    public static void fillRegistry(StudentRegistry studentRegistry){
//        Student april21BatchStudent = new Student();
//        april21BatchStudent.setBatch("April 21 Batch");
//        april21BatchStudent.setAverageBatchPsp(80.9);
//
//        studentRegistry.register(APRIL_21_BATCH, april21BatchStudent);
//
//        IntelligentStudent april21BatchIntelligentStudents = new IntelligentStudent();
//        april21BatchIntelligentStudents.setBatch("April 21 Batch");
//        april21BatchStudent.setAverageBatchPsp(95.1);
//
//        studentRegistry.register(APRIL_21_BATCH_INTELLIGENT_STUDENTS, april21BatchIntelligentStudents);
//    }
//
//    public static void main(String[] args) {
//        StudentRegistry studentRegistry = new StudentRegistry();
//        fillRegistry(studentRegistry);
//
//        // should I update the template itself?? No, I want to get a clone of it, and update that.
//        // the clone() method is executing the prototype.
//        List<Student> students = getAprilBatchStudents(studentRegistry);
//        List<Student> intelligentStudents = getAprilBatchIntelligentStudents(studentRegistry);
//    }
//
//    private static List<Student> getAprilBatchStudents(StudentRegistry studentRegistry){
//        Student sid = studentRegistry.get(APRIL_21_BATCH).clone();
//        sid.setName("Siddarth");
//        sid.setAge(30);
//        sid.setStudentPsp(90);
//
//        Student mohit = studentRegistry.get(APRIL_21_BATCH).clone();
//        mohit.setName("Mohit");
//        mohit.setAge(28);
//        mohit.setStudentPsp(88);
//
//        Student rahul = studentRegistry.get(APRIL_21_BATCH).clone();
//        mohit.setName("Rahul");
//        mohit.setAge(25);
//        mohit.setStudentPsp(80);
//
//        List<Student> students = new ArrayList<>();
//        students.add(sid);
//        students.add(mohit);
//        students.add(rahul);
//
//        return students;
//    }
//
//    private static List<Student> getAprilBatchIntelligentStudents(StudentRegistry studentRegistry){
//        Student rajat = studentRegistry.get(APRIL_21_BATCH_INTELLIGENT_STUDENTS).clone();
//        rajat.setName("Rajat");
//        rajat.setAge(30);
//        rajat.setStudentPsp(98);
//
//        Student chaitanya = studentRegistry.get(APRIL_21_BATCH_INTELLIGENT_STUDENTS).clone();
//        chaitanya.setName("Chaitanya");
//        chaitanya.setAge(28);
//        chaitanya.setStudentPsp(99);
//
//        Student lavanya = studentRegistry.get(APRIL_21_BATCH_INTELLIGENT_STUDENTS).clone();
//        lavanya.setName("Lavanya");
//        lavanya.setAge(25);
//        lavanya.setStudentPsp(98.5);
//
//        List<Student> students = new ArrayList<>();
//        students.add(rajat);
//        students.add(chaitanya);
//        students.add(lavanya);
//
//        return students;
//    }
//}
