package edu.umb.cs680.hw15;

public class Minimum implements Operations{
    @Override
    public double calculate(int a, int b) {
        int m=Math.min(a,b);
        return m;
    }
}
