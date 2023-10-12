package factorypattern.beans.menu;

public class IOSMenu implements Menu{
    @Override
    public void getDetails() {
        System.out.println("this is an IOS Menu");
    }
}
