package edu.umb.cs680.hw15;
public class Division implements Operations{
    @Override
    public double calculate(int a, int b) {
        int res= a/b;
        return res;
    }
}
