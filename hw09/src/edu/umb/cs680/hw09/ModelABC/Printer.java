package edu.umb.cs680.hw09.ModelABC;

public class Printer {
    private static Printer p=null;
    public static Printer getInstance(){
        if(p==null){
            p=new Printer();
        }
        return p;
    }
    public static void print() {
        System.out.println("Print of Printer's function");
    }
}
