package singleton.eagerloading;

public class Client {
    public static void main(String[] args){
        DBConnection dbConnection = DBConnection.getInstance();
        dbConnection.save("hello students");
    }
}
