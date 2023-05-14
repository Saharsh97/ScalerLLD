package factorypattern.beans.buttons;

public class IOSButton implements Button{
    @Override
    public void getName() {
        System.out.println("This is an IOS button");
    }
}
