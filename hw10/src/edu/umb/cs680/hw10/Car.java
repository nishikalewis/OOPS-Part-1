package edu.umb.cs680.hw10;

import java.util.ArrayList;
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
        public static List<Double> MinMaxNormalisation(int a, int b, int c){
            List<Double> nm=new ArrayList<>();
            int x=Math.min(Math.min(a,b),c);
            int y=Math.max(Math.max(a,b),c);
            //System.out.println(y);
            nm.add((double)(a-x)/(y-x));
            nm.add((double)(b-x)/(y-x));
            nm.add((double)(c-x)/(y-x));
            //System.out.println(nm.get(0));
            return nm;


        }

    }


