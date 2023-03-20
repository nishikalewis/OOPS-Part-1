package edu.umb.cs680.hw03;

public class car {
    private int mileage, year;
    private float price;
    private String model, make;

    public car(String make,String model, int year,int mileage, float price) {
        this.mileage = mileage;
        this.year = year;
        this.price = price;
        this.model = model;
        this.make = make;
    }
    public int getMileage(){
        return this.mileage;
    }
    public int getYear(){
        return this.year;
    }

    public float getPrice(){
        return this.price;
    }
    public String getModel(){
        return this.model;
    }
    public String getMake(){
        return this.make;
    }

    public static void main(String[] args) {
        car c1 = new car ("Hyundai","i20",2020,15,17000);
        System.out.println("Make: " + c1.getMake());
        System.out.println("Model: " + c1.getModel());
        System.out.println("Year: " + c1.getYear());
    }
}
