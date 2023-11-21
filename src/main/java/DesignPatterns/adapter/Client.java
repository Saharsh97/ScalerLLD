package DesignPatterns.adapter;

public class Client {

    // the user, using the PhonePe App.
    public static void main(String[] args) {
        PhonePe phonePe = new PhonePe();    // logs in

        phonePe.getBalance();
        phonePe.doTransaction("A", "B", 200);
    }
}
