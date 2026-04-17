package carmanagementsystem;

import java.sql.*;

public class DBOperations extends DBConnection{
    
    // create/insert
    @Override
    public void insertOperation(String brand, String model, int year, double price, boolean isAvailable){
        //DBConnection dbc = new DBConnection();
        try{
            // step 3: create statement
            String query = "INSERT INTO cars(brand, model, year, price, is_available) VALUES(?, ?, ?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, brand);
            pst.setString(2, model);
            pst.setInt(3, year);
            pst.setDouble(4, price);
            pst.setBoolean(5, isAvailable);
            
            // step 4: Execute statement
            int rowsAffected = pst.executeUpdate();
            
            // step 5: process resultset 
            if (rowsAffected > 0){
                System.out.println("Car inserted successfully!");
            }
            
            // step 6: close statement
            pst.close();
        }catch(SQLException sqle){
            System.out.println("Insert Operation failed: "+ sqle.getMessage());
        }
    }
    
    // create/insert specific record
    @Override
    public void insertOperation1(int car_id,String brand, String model, int year, double price, boolean isAvailable){
        try{
            // step 3
            String query = "INSERT INTO cars(car_id, brand, model, year, price, is_available) VALUES(?, ?, ?, ?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, car_id);
            pst.setString(2, brand);
            pst.setString(3, model);
            pst.setInt(4, year);
            pst.setDouble(5, price);
            pst.setBoolean(6, isAvailable);
            
            // step 4: execute statement
            int rowsAffected = pst.executeUpdate();
            
            // step 5: Process ResultSet
            if(rowsAffected > 0){
                System.out.println("Car inserted successfully");
            }
            
            // step 6: close statement
            pst.close();
        }catch(SQLException sqle){
            System.out.println("Insert Operation failed: "+sqle.getMessage());
        }
    }
    
    // read/select
    @Override
    public void selectOperation(int car_id){
        try{
            // step 3: create statement
            String query = "SELECT * FROM cars WHERE car_id = ?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, car_id);
            
            // step 4: Execute statement
            ResultSet rs = pst.executeQuery();
            
            // step 5: Process ResultSet
            System.out.println("Search result for Car ID: "+car_id+" ...");
            boolean found = false;
            while(rs.next()){
                found = true;
                int id = rs.getInt("car_id");
                String brand = rs.getString("brand");
                String model = rs.getString("model");
                int year = rs.getInt("year");
                double price = rs.getDouble("price");
                boolean isAvailable = rs.getBoolean("is_available");
                String available = isAvailable ? "Yes" : "No";
                
                System.out.println("Car ID: "+id);
                System.out.println("Brand: "+brand);
                System.out.println("Model: "+model);
                System.out.println("Year: "+year);
                System.out.println("Price: "+price+" /day");
                System.out.println("Available: "+available);
                System.out.println();
            }
            if(!found){
                System.out.println("No car found with ID: " + car_id);
            }
            
            // step 6: close statement
            rs.close();
            pst.close();
        }catch(SQLException sqle){
            System.out.println("Operation failed: " +sqle.getMessage());
        }
    }
    
    // read/select all records
    @Override
    public void selectAllOperation(){
        try{
            // step 3: create statement
            String query = "SELECT * FROM cars ORDER BY car_id";
            Statement st = con.createStatement();
            
            // step 4: execute statement
            ResultSet rs = st.executeQuery(query);
            
            // step 5: Process ResultSet
            boolean found = false;
            while(rs.next()){
                found = true;
                int id = rs.getInt("car_id");
                String brand = rs.getString("brand");
                String model = rs.getString("model");
                int year = rs.getInt("year");
                double price = rs.getDouble("price");
                String isAvailable = rs.getBoolean("is_available") ? "Yes" : "No";
                System.out.println("Car ID: "+id);
                System.out.println("Brand: "+brand);
                System.out.println("Model: "+model);
                System.out.println("Year: "+year);
                System.out.println("Price: "+price+" /day");
                System.out.println("Available: "+isAvailable);
                System.out.println();
                
            }
            if(found){
                System.out.println("No more cars found in the database.");
            }
            
            // step 6: close statement
            rs.close();
            st.close();
        }catch(SQLException sqle){
            System.out.println("Select All Operation Failed: " +sqle.getMessage());
        }
    }
    
    // update
    @Override
    public void updateOperation(int car_id, String brand, String model, int year, double price, boolean isAvailable){
        try{
            // step 3: create statement
            String query = "UPDATE cars SET brand = ?,model = ?, year = ?, price = ?, is_available = ? WHERE car_id = ?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, brand);
            pst.setString(2, model);
            pst.setInt(3, year);
            pst.setDouble(4, price);
            pst.setBoolean(5, isAvailable);
            pst.setInt(6, car_id);
            
            // step 4: execute statement
            int rowsAffected = pst.executeUpdate();
            
            // step 5: process result
            if(rowsAffected > 0){
                System.out.println("Car with ID " +car_id+ " updated successfully! "+ rowsAffected + " car(s) updated.");
                System.out.println("New values - brand: "+brand+", Model: "+model+", year: "+year);
                System.out.println("Price: "+price+"/day, Available: "+ (isAvailable ? "Yes" : "No"));
            }else{
                System.out.println("No car found with ID: " +car_id);
            }
            
            // step 6: Close statement
            pst.close();
        } catch(SQLException sqle){
            System.out.println("Operation failed: "+sqle.getMessage());
        }
    }
    
    // delete/drop
    @Override
    public void deleteOperation(int car_id){
        try{
            // step 3: create statement
            String query = "DELETE FROM cars WHERE car_id = ?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, car_id);
            
            // step 4: execute statement
            int rowsAffected = pst.executeUpdate();
            
            // Step 5: process result
            if(rowsAffected > 0){
                System.out.println("Car with ID "+ car_id +" deleted successfully!"+ rowsAffected + "car(s) deleted.");
            }else{
                System.out.println("No car found with ID: " + car_id);
            }
            
            // Step 6: Close statement
            pst.close();
        }catch(SQLException sqle){
            System.out.println("Delete Operation failed: " + sqle.getMessage());
        }
    }
    
    public void closeConnection(){
        try{
            if(con != null && !con.isClosed()){
                con.close();
                System.out.println("Database connection closed successfully");
            }
        } catch(SQLException sqle){
            System.out.println("Error closing connection: " +sqle.getMessage());
        }
    }
}
