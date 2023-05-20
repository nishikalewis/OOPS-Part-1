package edu.umb.cs680.hw15;

public class Maximum implements Operations{
    @Override
    public double calculate(int a, int b) {
        int m=Math.max(a,b);
        return m;
    }
}
