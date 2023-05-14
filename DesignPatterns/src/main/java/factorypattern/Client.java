package factorypattern;

import factorypattern.beans.buttons.Button;
import factorypattern.beans.menu.Menu;
import factorypattern.enums.SupportedPlatform;
import factorypattern.factories.UIFactory;
import factorypattern.service.Flutter;

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
