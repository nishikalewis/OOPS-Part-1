package edu.umb.cs680.hw13;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    List<Car> usedCars=new ArrayList<>();

    @Test
    public void check_PriceComparator(){
        Car c1=new Car("volkswagen","hatchbag",2020,25,300000);
        usedCars.add(c1);
        Car c2=new Car("polo","sedan",2018,20,100000);
        usedCars.add(c2);
        Car c3=new Car("kia","suv",2022,30,5000000);
        usedCars.add(c3);
        Collections.sort(usedCars, Comparator.comparing(Car::getPrice,
                Comparator.naturalOrder() ));
        String [] a={"polo","volkswagen","kia"};
        assertEquals(a[1],usedCars.get(1).getMake());
    }
    @Test
    public void check_YearComparator(){
        Car c1=new Car("volkswagen","hatchbag",2020,25,300000);
        usedCars.add(c1);
        Car c2=new Car("polo","sedan",2018,20,100000);
        usedCars.add(c2);
        Car c3=new Car("kia","suv",2022,30,5000000);
        usedCars.add(c3);
        Collections.sort(usedCars,Comparator.comparing((Car car)-> car.getYear() ));
        String [] a={"polo","volkswagen","kia"};
        assertEquals(a[2],usedCars.get(2).getMake());
    }
    @Test
    public void check_MileageComparator(){
        Car c1=new Car("volkswagen","hatchbag",2020,25,300000);
        usedCars.add(c1);
        Car c2=new Car("polo","sedan",2018,20,100000);
        usedCars.add(c2);
        Car c3=new Car("kia","suv",2022,30,5000000);
        usedCars.add(c3);
        Collections.sort(usedCars,(Car o1, Car o2)->
                (int)(o1.getMileage()- o2.getMileage()));
        String [] a={"polo","volkswagen","kia"};
        assertEquals(a[0],usedCars.get(0).getMake());
    }
    @Test
    public void check_ParetoComparator(){
        Car c1=new Car("volkswagen","hatchbag",2020,25,300000);
        usedCars.add(c1);
        Car c2=new Car("polo","sedan",2018,20,100000);
        usedCars.add(c2);
        Car c3=new Car("kia","suv",2022,30,5000000);
        usedCars.add(c3);
        for(Car car: usedCars){
            car.setDominationCount(usedCars); }
        Collections.sort(usedCars,Comparator.comparing( Car::getDominationCount ) );
        System.out.println(usedCars.get(2).getMake());
        String [] a={"polo","volkswagen","kia"};
        assertEquals(a[0],usedCars.get(0).getMake());
    }


}