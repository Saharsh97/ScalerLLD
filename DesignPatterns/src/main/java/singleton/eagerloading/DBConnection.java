package singleton.eagerloading;

public class DBConnection {
    static DBConnection instance = new DBConnection();

    private DBConnection(){}

    public static DBConnection getInstance(){
        return instance;
    }

    public void save(String message){
        System.out.println("Saved Message : " + message);
    }
}
