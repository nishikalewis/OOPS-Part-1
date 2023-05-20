package edu.umb.cs680.hw15;
public class Multiplication implements Operations{
    @Override
    public double calculate(int a, int b) {
        int product=(a*b);
        return product;
    }
}
