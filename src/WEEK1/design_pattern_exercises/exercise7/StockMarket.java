package WEEK1.design_pattern_exercises.exercise7;

import java.util.ArrayList;
import java.util.List;

class StockMarket implements Stock {
    private List<Observer> observers = new ArrayList<>();
    private double currentPrice;

    public void setPrice(double price) {
        this.currentPrice = price;
        notifyObservers();
    }

    public void register(Observer o) { observers.add(o); }
    public void deregister(Observer o) { observers.remove(o); }

    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(currentPrice);
        }
    }
}
