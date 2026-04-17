package carmanagementsystem;

import java.sql.*;

public abstract class DBConnection {
    
    String url ="jdbc:postgresql://localhost:5432/Car";
    String user = "postgres";
    String pass = "1234";
    
    Connection con;
    
    public DBConnection(){
        // step 1: load driver
        try{
            Class.forName("org.postgresql.Driver");
            System.out.println("Driver loaded successfully");
        }catch(ClassNotFoundException cnfe){
            System.out.println("Driver loading failed: "+cnfe.getMessage());
        }
        
        // step 2: establish connection
        try{
            con = DriverManager.getConnection(url, user, pass);
            System.out.println("Connected successfully to the database ");
        }catch(SQLException sqle){
            System.out.println("Databaseconnection failed: "+sqle.getMessage());
        }
    }
    
    // Abstract methods
    public abstract void insertOperation(String brand, String model, int year, double price, boolean isAvailable);
    public abstract void insertOperation1(int car_id,String brand, String model, int year, double price, boolean isAvailable);
    public abstract void selectOperation(int car_id);
    public abstract void selectAllOperation();
    public abstract void updateOperation(int car_id, String brand, String model, int year, double price, boolean isAvailable);
    public abstract void deleteOperation(int car_id);
}
