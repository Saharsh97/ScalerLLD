package DesignPatterns.decorator.starbuzz.types;

import DesignPatterns.decorator.starbuzz.Beverage;

public class IceTea implements Beverage {

    @Override
    public int getCost() {
        return 100;
    }

    @Override
    public String getDescription() {
        return "Ice Tea";
    }
}
