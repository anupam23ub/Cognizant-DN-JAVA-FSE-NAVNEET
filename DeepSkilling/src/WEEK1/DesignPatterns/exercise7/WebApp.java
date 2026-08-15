package WEEK1.DesignPatterns.exercise7;

class WebApp implements Observer {
    public void update(double price) {
        System.out.println("WebApp UI updated with new price: $" + price);
    }
}
