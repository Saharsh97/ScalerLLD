package DesignPatterns.decorator.starbuzz.addOns;

import DesignPatterns.decorator.starbuzz.Beverage;

public class Mocha implements Beverage {
    Beverage base;

    public Mocha(Beverage baseBeverage){
        base = baseBeverage;
    }

    @Override
    public int getCost() {
        return 50 + base.getCost();
    }

    @Override
    public String getDescription() {
        return "Mocha, " + base.getDescription();
    }
}
