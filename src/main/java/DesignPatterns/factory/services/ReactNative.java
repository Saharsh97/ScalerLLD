package DesignPatterns.factory.services;

import DesignPatterns.factory.factory.UIFactory;
import DesignPatterns.factory.factory.UIFactoryFactory;

public class ReactNative {
    public void optimize(){
        System.out.println("running optimizations");
    }

    public UIFactory createUIFactory(String platform){
        return UIFactoryFactory.getUIFactoryBasedOnPlatform(platform);
    }

    // DRY : Dont Repeat Yourself!
}
