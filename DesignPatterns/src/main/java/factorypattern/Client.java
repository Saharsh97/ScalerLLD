package factorypattern;

public class Client {
    public static void main(String[] args){
        Flutter flutter = new Flutter();

        flutter.setTheme();
        flutter.setRefreshRate();

        UIFactory uiFactory = flutter.createUIFactory(SupportedPlatform.IOS);

        Button button = uiFactory.createButton();
        button.getName();

        Menu menu = uiFactory.createMenu();
        menu.getDetails();
    }
}
