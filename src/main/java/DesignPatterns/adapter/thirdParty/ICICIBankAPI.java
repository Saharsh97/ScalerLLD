package DesignPatterns.adapter.thirdParty;

public class ICICIBankAPI {

    public int balanceCheck(){
        int balanceAmount = 1000;
        System.out.println("Your balance is Rs. " + balanceAmount);
        return balanceAmount;
    }

    public int sendMoney(String to, String from, int amount){
        System.out.println("Sending money from " + from + " to " + to + " amount: Rs. " + amount);
        return amount; // sending back amount as a confirmation.
    }
}
