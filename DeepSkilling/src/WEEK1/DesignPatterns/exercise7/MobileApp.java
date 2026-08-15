package WEEK1.DesignPatterns.exercise7;

class MobileApp implements Observer {
    public void update(double price) {
        System.out.println("MobileApp UI updated with new price: $" + price);
    }
}
