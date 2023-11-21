package DesignPatterns.adapter.adapters;

import DesignPatterns.adapter.thirdParty.YesBankAPI;

public class YesBankAPIAdapter implements BankAPI{
    YesBankAPI yesBankAPI = new YesBankAPI();

    @Override
    public double checkBalance() {
        return (double) yesBankAPI.getBalance();
    }

    @Override
    public boolean pay(int amount, String from, String to) {
        try{
            yesBankAPI.transferMoney(from, amount, to);
            System.out.println("confirmed Rs." + amount + ", paid to " + to);
            return true;
        } catch (Exception e){
            System.out.println("error occurred in transferring money from " + from + " to " + to);
            return false;
        }
    }
}
