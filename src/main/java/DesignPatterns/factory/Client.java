package DesignPatterns.factory;


import DesignPatterns.factory.components.Button.Button;
import DesignPatterns.factory.factory.UIFactory;
import DesignPatterns.factory.services.Flutter;
import DesignPatterns.factory.services.ReactNative;

public class Client {
    public static void main(String[] args) {
        Flutter f = new Flutter();
        f.setRefreshRate();
        f.setTheme();

        UIFactory uiFactory = f.createUIFactory("ANDROID");
        Button b = uiFactory.createButton();
        b.getSizeOfButton();

        ReactNative reactNative = new ReactNative();
        UIFactory uiFactory2 = reactNative.createUIFactory("IOS");
        Button b2 = uiFactory2.createButton();
        b2.getSizeOfButton();
    }
}
