package edu.umb.cs680.hw16;

public class StockEvent {
    String ticker;
    double quote;

    public StockEvent(String ticker,double quote) {
    }

    public String getTicker(){
        return this.ticker;
    }
    public double getQuote(){
        return this.quote;
    }
}
