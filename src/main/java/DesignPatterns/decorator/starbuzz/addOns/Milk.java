package DesignPatterns.decorator.starbuzz.addOns;

import DesignPatterns.decorator.starbuzz.Beverage;

public class Milk implements Beverage {
    Beverage base;

    public Milk(Beverage baseBeverage){
        base = baseBeverage;
    }

    @Override
    public int getCost() {
        return 10 + base.getCost();
    }

    @Override
    public String getDescription() {
        return "Milk, " + base.getDescription();
    }
}
