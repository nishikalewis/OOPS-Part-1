package edu.umb.cs680.hw16;

public class ThreeDObserver implements Observer{
    @Override
    public void update(Observable sender, Object event) {
        System.out.println("3DObserver");
        System.out.println(event);
    }
}
