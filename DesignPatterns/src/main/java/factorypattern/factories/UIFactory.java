package factorypattern.factories;

import factorypattern.beans.buttons.Button;
import factorypattern.beans.menu.Menu;

public interface UIFactory {
    public Button createButton();

    public Menu createMenu();
}
