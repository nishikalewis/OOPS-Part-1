package edu.umb.cs680.hw16;

import java.util.HashMap;
import java.util.Map;

public class StockQuoteObservable extends Observable{
    protected  Map<String,Double> m=new HashMap<String, Double>();

    public void changeQuote(String t,double q){
        m.put(t,q);
        notifyObservers(new StockEvent(t,q));
    }
    public HashMap<String,Double> getmap(){
        return (HashMap<String, Double>) m;
    }

    public static void main(String args[]) {
        StockQuoteObservable st=new StockQuoteObservable();
        LineChartObserver obs=new LineChartObserver();
        st.addObserver(obs);
        st.changeQuote("quote",10000);
    }

}
