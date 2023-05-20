package edu.umb.cs680.hw11;

import java.util.List;

public class Car {
    private int mileage, year;
    private float price;
    private String model, make;

    private int domCount;

    public Car(String make,String model, int year,int mileage, float price) {
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
    public int getDominationCount(){
        return this.domCount;
    }

    public void setDominationCount(List<Car> usedCars) {
        int ct=0;
        int a=this.getMileage();
        float b=this.getPrice();
        int d=this.getYear();
        for(Car cr:usedCars){
            int x=cr.getMileage();
            float y=cr.getPrice();
            int z=cr.getYear();
            if(x<=a && y<=b && d>=z){
                if(x<a || y<b || d>z){
                    ct++;
                }
            }
        }
        this.domCount = ct;
    }

    public static void main(String[] args) {
        Car c1 = new Car ("Hyundai","i20",2020,15,17000);
        System.out.println("Make: " + c1.getMake());
        System.out.println("Model: " + c1.getModel());
        System.out.println("Year: " + c1.getYear());
    }
}
