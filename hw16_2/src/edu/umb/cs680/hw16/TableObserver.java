package edu.umb.cs680.hw16;

public class TableObserver implements Observer{

    @Override
    public void update(Observable sender, Object event) {
        System.out.println("TableObserver");
        System.out.println(event);
    }
}
