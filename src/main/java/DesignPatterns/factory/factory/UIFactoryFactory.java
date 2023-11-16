package DesignPatterns.factory.factory;


// factory method: createSound() to get the right Sound
// factory method: createQuery() to get the right Query
// factory method: createUIFactorFactory() to get the right UIFactory

public class UIFactoryFactory {
    public static UIFactory getUIFactoryBasedOnPlatform(String platform){
        if(platform.equals("ANDROID")){
            return new AndroidUIFactory();
        } else if(platform.equals("IOS")){
            return new IOSUIFactory();
        }
        return null;
    }
}
