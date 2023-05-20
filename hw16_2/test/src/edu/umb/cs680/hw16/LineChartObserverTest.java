package edu.umb.cs680.hw16;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LineChartObserverTest {
    @Test
    public void check_LCO() {
        StockQuoteObservable st = new StockQuoteObservable();
        LineChartObserver lc=new LineChartObserver();
        st.addObserver(lc);
        st.changeQuote("quotevalue",1000);
        int c= st.countObservers();
        assertEquals(1,c);
        st.removeObserver(lc);

    }

}