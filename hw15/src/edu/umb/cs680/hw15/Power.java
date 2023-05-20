package edu.umb.cs680.hw15;

public class Power implements Operations{
    @Override
    public double calculate(int a, int b) {
        int p= (int) Math.pow(a,b);
        return p;
    }
}
