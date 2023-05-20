package edu.umb.cs680.hw15;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    int a=10,b=5;

    @Test
    public void check_add(){
        double act= Calculator.get(a,b,new Addition());
        assertEquals(15.0,act);
    }
    @Test
    public void check_sub(){
        double act= Calculator.get(a,b,new Subtraction());
        assertEquals(5.0,act);
    }

    @Test
    public void check_mul(){
        double act= Calculator.get(a,b,new Multiplication());
        assertEquals(50.0,act);
    }
    @Test
    public void check_div(){
        double act= Calculator.get(a,b,new Division());
        assertEquals(2.0,act);
    }
    @Test
    public void check_pow(){
        double act= Calculator.get(a,b,new Power());
        assertEquals(100000.0,act);
    }
    @Test
    public void check_min(){
        double act= Calculator.get(a,b,new Minimum());
        assertEquals(5.0,act);
    }

    @Test
    public void check_max(){
        double act= Calculator.get(a,b,new Maximum());
        assertEquals(10.0,act);
    }

    @Test
    public void check_avg(){
        double act= Calculator.get(a,b,new Average());
        assertEquals(7.5,act);
    }
}