package DesignPatterns.adapter.thirdParty;

public class YesBankAPI {

    public int getBalance(){
        System.out.println("Your balance is Rs. " + 500);
        return 500;
    }

    public void transferMoney(String from, int amount, String to){
        System.out.println("crediting amount " + amount + " to " + to + "'s Bank Account from " + from + "'s Bank Account");
    }
}
