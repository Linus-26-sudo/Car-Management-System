package carmanagementsystem;

public class Car {
    
    // attributes
    private int carId;
    private String brand;
    private String model;
    private int year;
    private double price;
    private boolean isAvailable;
    
    // methods/functions
    
    // default constructor
    public Car(){
        carId = 0;
        brand = "Unknown";
        model = "Unknown";
        year = 0;
        price = 0.0;
        isAvailable = true;;
    }
    
    // parameterised constructor
    public Car(int carId, String brand, String model, int year, double price,
        boolean isAvailable){
        this.carId = carId;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.price = price;
        this.isAvailable = isAvailable;
    }
    
    // getters and setters
    public int getCarId(){
        return carId;
    }
    public void setCarId(int carId){
        this.carId = carId;
    }
    public String getBrand(){
        return brand;
    }
    public void setBrand(String brand){
        this.brand = brand;
    }
    public String getModel(){
        return model;
    }
    public void setModel(String model){
        this.model = model;
    }
    public int getYear(){
        return year;
    }
    public void setYear(int year){
        this.year = year;
    }
    public double getPrice(){
        return price;
    } 
    public void setPrice(double price){
        this.price = price;
    }
    public boolean isAvailable(){
        return isAvailable;
    }
    public void setAvailable(boolean isAvailable){
        this.isAvailable = isAvailable;
    }
    
    public void rentCar(){
        if(isAvailable == true){
            isAvailable = false;
            System.out.println("Car rented successfully.");
        }else{
            System.out.println("Sorry, the car is not available for rent");
        }
    }
    
    public void returnCar(){
        if(isAvailable == false){
            isAvailable = true;
            System.out.println("Car is returned successfully");
        }else{
            System.out.println("Car has not been returned");
        }
    }
    
    public void serviceCar(){
        System.out.println("Car "+carId+" is now being serviced");
    }
    
    public String getCarDetails() {
        return "Car ID: " + carId +"," + brand + "," + model+ year + ", "+ "Rental Price: $" + price + "/day , Available: " +(isAvailable ? "Yes" : "No");
    }
    
}
