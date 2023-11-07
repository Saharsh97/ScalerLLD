package factorypattern.beans.buttons;

public class AndroidButton implements factorypattern.beans.buttons.Button {
    @Override
    public void getName() {
        System.out.println("This is an Android Button");
    }
}
