package main.java.OOPS.interfacesdemo;

public class SimpleInterest implements Interest{
    int principle;
    int roi;

    SimpleInterest(int x, int y){
        principle = x;
        roi = y;
    }

    public int computeInterestAmount(){
        return principle * roi;
    }
}
