package DesignPatterns.factory.factory;

import DesignPatterns.factory.components.Button.Button;
import DesignPatterns.factory.components.Button.IOSButton;
import DesignPatterns.factory.components.DropDown.DropDown;
import DesignPatterns.factory.components.DropDown.IOSDropDown;
import DesignPatterns.factory.components.Menu.IOSMenu;
import DesignPatterns.factory.components.Menu.Menu;

public class IOSUIFactory implements UIFactory{

    @Override
    public Button createButton() {
        return new IOSButton();
    }

    @Override
    public Menu createMenu() {
        return new IOSMenu();
    }

    @Override
    public DropDown createDropDown() {
        return new IOSDropDown();
    }
}
