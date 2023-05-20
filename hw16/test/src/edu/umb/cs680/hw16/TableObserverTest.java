package edu.umb.cs680.hw16;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TableObserverTest {
    @Test
    public void check_TO() {
        StockQuoteObservable st = new StockQuoteObservable();
        TableObserver lc=new TableObserver();
        st.addObserver(lc);
        st.changeQuote("quotevalue",1000);
        int c= st.countObservers();
        assertEquals(1,c);
        st.removeObserver(lc);

    }


}