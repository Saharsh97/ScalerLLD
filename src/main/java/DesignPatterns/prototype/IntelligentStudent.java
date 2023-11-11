package main.java.DesignPatterns.prototype;

public class IntelligentStudent extends Student{
    int iq;

    public IntelligentStudent(){}

    IntelligentStudent(IntelligentStudent x){
        super(x);
        this.iq = x.iq;
    }
    // IntelligentStudent base;
    // IntelligentStudent copy = base.clone();

    @Override
    public IntelligentStudent clone(){
        return new IntelligentStudent(this);
    }

    public int getIq() {
        return iq;
    }

    public void setIq(int iq) {
        this.iq = iq;
    }
}
