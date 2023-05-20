package edu.umb.cs680.hw15;

public class Addition implements Operations{
    @Override
    public double calculate(int a, int b) {
        int sum=a+b;
        return sum;
    }
}
