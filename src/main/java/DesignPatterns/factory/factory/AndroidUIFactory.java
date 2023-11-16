package DesignPatterns.factory.factory;

import DesignPatterns.factory.components.Button.AndroidButton;
import DesignPatterns.factory.components.Button.Button;
import DesignPatterns.factory.components.DropDown.AndroidDropDown;
import DesignPatterns.factory.components.DropDown.DropDown;
import DesignPatterns.factory.components.Menu.AndroidMenu;
import DesignPatterns.factory.components.Menu.Menu;

public class AndroidUIFactory implements UIFactory{
    @Override
    public Button createButton() {
        return new AndroidButton();
    }

    @Override
    public Menu createMenu() {
        return new AndroidMenu();
    }

    @Override
    public DropDown createDropDown() {
        return new AndroidDropDown();
    }
}
