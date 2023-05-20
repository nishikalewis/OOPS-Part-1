package edu.umb.cs680.hw15;
import java.util.List;

public class Calculator {
//    public static double get(int a,int b) {
//        return Calculator.get(a, b,new Addition());
//    }
    public static double get(int a,int b, Operations op) {
        return op.calculate(a, b);
    }
    public static void main(String args[]) {
        int x=15,y=10;
        double value= Calculator.get(x,y,new Addition());
        System.out.print("Sum of Numbers= ");
        System.out.print(value);
    }
    }


