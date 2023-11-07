package factorypattern.beans.buttons;

public class IOSButton implements factorypattern.beans.buttons.Button {
    @Override
    public void getName() {
        System.out.println("This is an IOS button");
    }
}
