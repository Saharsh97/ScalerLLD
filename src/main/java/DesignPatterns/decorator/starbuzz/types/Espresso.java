package DesignPatterns.decorator.starbuzz.types;

import DesignPatterns.decorator.starbuzz.Beverage;

public class Espresso implements Beverage {
    @Override
    public int getCost() {
        return 250;
    }

    @Override
    public String getDescription() {
        return "Simple Espresso";
    }
}
