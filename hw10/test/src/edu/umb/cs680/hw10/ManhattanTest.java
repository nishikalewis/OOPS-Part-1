package edu.umb.cs680.hw10;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ManhattanTest {
    List<Double> p1, p2;

    @Test
    public void check_ManhanttanDistance() {
        p1 = List.of(2.0, 3.0);
        p2 = List.of(5.0, 7.0);
        Double actual_value=Distance.get(p1, p2,new Manhattan());
        assertEquals(7,actual_value);

    }

    @Test
    public void check_mMatrix(){
        p1 = List.of(2.0, 3.0);
        p2 = List.of(5.0, 7.0);
        List<List<Double>> points = List.of(p1,p2);
        List<List<Double>> act=Distance.matrix(points,new Manhattan());
        List<List<Double>> exp=new ArrayList<>();
        exp.add(Arrays.asList(0.0,7.0));
        exp.add(Arrays.asList(7.0,0.0));
        assertArrayEquals(exp.toArray(),act.toArray());
    }

    @Test
    public void check_carIns(){
        Car value1=new Car("volkswagen","hatchbag",2020,25,300000);
        Car value2=new Car("polo","sedan",2018,20,100000);
        Car value3=new Car("kia","suv",2022,30,5000000);
        Car value4=new Car("Nissan","xuv",2011,19,500000);
        Car value5=new Car("Toyota","Muv",2019,18,300000);
        Car value6=new Car("Mercedez","Covertible",2017,20,700000);
        List<List<Double>> points = new ArrayList<>();
        points.add(Car.MinMaxNormalisation(value1.getMileage(),value1.getYear(), (int) value1.getPrice()));
        points.add(Car.MinMaxNormalisation(value2.getMileage(),value2.getYear(), (int) value2.getPrice()));
        points.add(Car.MinMaxNormalisation(value3.getMileage(),value3.getYear(), (int) value3.getPrice()));
        points.add(Car.MinMaxNormalisation(value4.getMileage(),value4.getYear(), (int) value4.getPrice()));
        points.add(Car.MinMaxNormalisation(value5.getMileage(),value5.getYear(), (int) value5.getPrice()));
        points.add(Car.MinMaxNormalisation(value6.getMileage(),value6.getYear(), (int) value6.getPrice()));
        List<List<Double>> act=Distance.matrix(points,new Manhattan());
        List<Double>exp=
               List.of(0.0, 0.013333442586508799, 0.006252151822436729, 0.002666402815097957, 1.984601116236922E-5, 0.003797615557460917);
        assertEquals(exp,act.get(0));
    }
}