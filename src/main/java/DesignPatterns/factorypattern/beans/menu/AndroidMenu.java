package factorypattern.beans.menu;

public class AndroidMenu implements Menu{
    @Override
    public void getDetails() {
        System.out.println("this is an Android Menu");
    }
}
