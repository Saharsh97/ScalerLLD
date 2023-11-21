package DesignPatterns.adapter.adapters;

import DesignPatterns.adapter.thirdParty.ICICIBankAPI;

public class ICICIBankAPIAdapter implements BankAPI{
    ICICIBankAPI iciciBankAPI = new ICICIBankAPI();

    @Override
    public double checkBalance() {
        return (double) iciciBankAPI.balanceCheck();
    }

    @Override
    public boolean pay(int amount, String from, String to) {
        try{
            int confirmedAmount = iciciBankAPI.sendMoney(to, from, amount);
            System.out.println("confirmed Rs." + confirmedAmount + ": paid to " + to);
            return true;
        } catch (Exception e){
            System.out.println("error occurred in transferring money from " + from + " to " + to);
            return false;
        }
    }
}
