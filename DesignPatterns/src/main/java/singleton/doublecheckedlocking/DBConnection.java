package singleton.doublecheckedlocking;

public class DBConnection {
    static DBConnection instance = null;

    private DBConnection(){}

    public static DBConnection getInstance(){
        if(instance == null){
            synchronized (DBConnection.class) {
                if(instance == null) {
                    instance = new DBConnection();
                }
            }
        }
        return instance;
    }

    public void save(String message){
        System.out.println("Saved Message : " + message);
    }
}
