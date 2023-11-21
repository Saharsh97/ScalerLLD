package DesignPatterns.adapter;

import DesignPatterns.adapter.adapters.BankAPI;
import DesignPatterns.adapter.adapters.ICICIBankAPIAdapter;
import DesignPatterns.adapter.adapters.YesBankAPIAdapter;
import DesignPatterns.adapter.thirdParty.ICICIBankAPI;
import DesignPatterns.adapter.thirdParty.YesBankAPI;

public class PhonePe {
//    YesBankAPI yesBankAPI = new YesBankAPI();
//
//    public double getBalance(){
//        return yesBankAPI.getBalance();
//    }
//
//    public void doTransaction(String from, String to, int amount){
//        yesBankAPI.transferMoney(from, amount, to);
//    }


//    ICICIBankAPI iciciBankAPI = new ICICIBankAPI();
//
//    public double getBalance(){
//        return iciciBankAPI.balanceCheck();
//    }
//
//    public void doTransaction(String from, String to, int amount){
//        iciciBankAPI.sendMoney(to, from, amount);
//    }




//    // V2
    BankAPI bankAPI = new ICICIBankAPIAdapter();

    public double getBalance(){
        return bankAPI.checkBalance();
    }

    public boolean doTransaction(String from, String to, int amount){
        return bankAPI.pay(amount, from, to);
    }
}
