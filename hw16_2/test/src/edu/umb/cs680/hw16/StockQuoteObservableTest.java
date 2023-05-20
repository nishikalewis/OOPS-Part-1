package edu.umb.cs680.hw16;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StockQuoteObservableTest {

    @Test
    public void check_changeQu(){
        StockQuoteObservable st=new StockQuoteObservable();
        LineChartObserver s1=new LineChartObserver();
        ThreeDObserver s2=new ThreeDObserver();
        TableObserver s3=new TableObserver();
        st.addObserver(s1);
        st.addObserver(s2);
        st.addObserver(s3);
        st.changeQuote("quotevalue",1000);
        List<Observer> obs=st.getObservers();
        System.out.println(obs.get(0).getClass());
        HashMap<String,Double> nm= new HashMap<>();
        nm.put("quotevalue", 1000.0);
        assertEquals(nm,st.getmap());
        st.clearObservers();
    }
    @Test
    public void check_LExp(){
        StockQuoteObservable st=new StockQuoteObservable();
        Observer s1=(((sender, event) -> {  System.out.println("LinechartObserver");
            System.out.println(event);}));
        Observer s2=(((sender, event) -> {  System.out.println("TablechartObserver");
            System.out.println(event);}));
        Observer s3=(((sender, event) -> {  System.out.println("3DObserver");
            System.out.println(event);}));
        st.addObserver(s1);
        st.addObserver(s2);
        st.addObserver(s3);
        st.changeQuote("quotevalue",1000);
        List<Observer> obs=st.getObservers();
        System.out.println(obs.get(0).getClass());
        HashMap<String,Double> nm= new HashMap<>();
        nm.put("quotevalue", 1000.0);
        assertEquals(nm,st.getmap());
        st.clearObservers();
    }
}