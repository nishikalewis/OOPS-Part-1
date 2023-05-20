package edu.umb.cs680.hw15;

public class Average implements Operations{
    @Override
    public double calculate(int a, int b) {
        double avg=(double)(a+b)/2;
        return avg;
    }
}
