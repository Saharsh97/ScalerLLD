package factorypattern.factories;

import factorypattern.beans.buttons.AndroidButton;
import factorypattern.beans.menu.AndroidMenu;
import factorypattern.beans.buttons.Button;
import factorypattern.beans.menu.Menu;

public class AndroidUIFactory implements UIFactory{
    @Override
    public Button createButton() {
        return new AndroidButton();
    }

    @Override
    public Menu createMenu() {
        return new AndroidMenu();
    }
}
