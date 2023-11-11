package main.java.DesignPatterns.prototypeExplanation;

// <1> implements what?
// what is the return type of Student.
// how do you declare the datatype here?
// any doubts here?

// <2> create Registry.
// </2> clear so far with registry?
public class Student implements Prototype<Student>{
    private int age;
    private String name;
    private String batch;
    private double averageBatchPsp;
    private double studentPsp;

    @Override
    public Student clone() {
        return new Student(this);
    }

    public Student(){}

    public Student(Student s){
        this.age = s.age;
        this.name = s.name;
        this.batch = s.batch;
        this.averageBatchPsp = s.averageBatchPsp;
        this.studentPsp = s.studentPsp;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public double getAverageBatchPsp() {
        return averageBatchPsp;
    }

    public void setAverageBatchPsp(double averageBatchPsp) {
        this.averageBatchPsp = averageBatchPsp;
    }

    public double getStudentPsp() {
        return studentPsp;
    }

    public void setStudentPsp(double studentPsp) {
        this.studentPsp = studentPsp;
    }
}
