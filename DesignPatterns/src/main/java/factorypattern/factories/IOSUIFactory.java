package factorypattern.factories;

import factorypattern.beans.buttons.Button;
import factorypattern.beans.buttons.IOSButton;
import factorypattern.beans.menu.IOSMenu;
import factorypattern.beans.menu.Menu;

public class IOSUIFactory implements UIFactory{
    @Override
    public Button createButton() {
        return new IOSButton();
    }

    @Override
    public Menu createMenu() {
        return new IOSMenu();
    }
}
