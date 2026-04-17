package carmanagementsystem;

public class Test {
    
    public static void main(String[] args){
        DBOperations dbo = new DBOperations();
        
        /*System.out.println("=== Car Management System ===");
        System.out.println();
        
        System.out.println("== INSERTING CARS INTO THE DATABASE ==");
        dbo.insertOperation("BMW", "X5", 2022, 4800.00, false);
        dbo.insertOperation("Mitstubishi", "Outlander", 2019, 3000.00, true);
        dbo.insertOperation("Toyota", "Harrier", 2020, 2800.00, true);
        dbo.insertOperation("Land Rover", "Discovery 3", 2020, 3500.00, false);
        System.out.println();*/
        
        /*System.out.println("== SEARCHING FOR A SPECIFIC CAR ==");
        dbo.selectOperation(1);
        dbo.selectOperation(2);
        dbo.selectOperation(3);
        dbo.selectOperation(4);
        dbo.selectOperation(5);
        dbo.selectOperation(6);
        dbo.selectOperation(7);
        dbo.selectOperation(8);
        dbo.selectOperation(9);
        dbo.selectOperation(10);
        dbo.selectOperation(11);
        dbo.selectOperation(12);
        dbo.selectOperation(13);
        dbo.selectOperation(14);
        dbo.selectOperation(15);
        dbo.selectOperation(16);
        System.out.println();*/
        
        /*System.out.println("== DISPLAYING ALL CARS ==");
        dbo.selectAllOperation();*/
        
        /*System.out.println("== UPDATING CARS INFORMATION ==");
        dbo.updateOperation(7, "Subaru", "WRX", 2023, 3500.00, false);
        dbo.updateOperation(8, "Toyota", "TX", 2020, 3200.00, true);
        dbo.updateOperation(9, "Mazda", "CX - 3", 2020, 2600.00, true);*/
        
        /*System.out.println("== DELETING CARS INFORMATION ==");
        dbo.deleteOperation(4);*/
        
        /*System.out.println();
        System.out.println("== Car Information Data ==");
        System.out.println();
        dbo.selectAllOperation();*/
        
        /*System.out.println("== DELETING A NON-EXISTENT CAR");
        dbo.deleteOperation(20);*/
        
        System.out.println("== INSERTING A CAR INTO THE DATABASE ==");
        //dbo.insertOperation1(2, "Suzuki", "Jimmny", 2025, 2000.00, true);
        dbo.insertOperation1(4, "Ford", "Ranger", 2025, 4000.00, false);
        
        dbo.closeConnection();
    }
    
}
