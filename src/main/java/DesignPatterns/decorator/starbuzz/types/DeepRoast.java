package DesignPatterns.decorator.starbuzz.types;

import DesignPatterns.decorator.starbuzz.Beverage;

public class DeepRoast implements Beverage {

    @Override
    public int getCost() {
        return 300;
    }

    @Override
    public String getDescription() {
        return "Deep Roast";
    }
}
