package DesignPatterns.factory.factory;

import DesignPatterns.factory.components.Button.Button;
import DesignPatterns.factory.components.DropDown.DropDown;
import DesignPatterns.factory.components.Menu.Menu;

public interface UIFactory {    // Abstract Factory
    Button createButton();
    Menu createMenu();
    DropDown createDropDown();
}
