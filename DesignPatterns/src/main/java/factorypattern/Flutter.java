package factorypattern;

public class Flutter {

    public Flutter(){}

    public void setTheme(){
        System.out.println("setting theme to Dark");
    }

    public void setRefreshRate(){
        System.out.println("Set refresh rate 60 fps");
    }

    public UIFactory createUIFactory(SupportedPlatform platform){
        if(platform.equals(SupportedPlatform.ANDROID)){
            return new AndroidUIFactory();
        } else if(platform.equals(SupportedPlatform.IOS)){
            return new IOSUIFactory();
        }
        return null;
    }
}
