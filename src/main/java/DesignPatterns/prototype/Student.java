package main.java.DesignPatterns.prototype;

public class Student implements Prototype<Student>{
    private int id;
    private String name;
    private int age;
    private String batch;
    private double psp;
    private double batchAveragePsp;

    public Student(){}

    public Student(Student x){
        this.id = x.id;
        this.name = x.name;
        this.age = x.age;
        this.batch = x.batch;
        this.psp = x.psp;
        this.batchAveragePsp = x.batchAveragePsp;
    }

    // Student h = base.clone()

    @Override
    public Student clone() {
        return new Student(this);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public double getPsp() {
        return psp;
    }

    public void setPsp(double psp) {
        this.psp = psp;
    }

    public double getBatchAveragePsp() {
        return batchAveragePsp;
    }

    public void setBatchAveragePsp(double batchAveragePsp) {
        this.batchAveragePsp = batchAveragePsp;
    }
}
