package WEEK1.design_pattern_exercises.exercise7;

public class ObserverTest {
    public static void main(String[] args) {
        StockMarket techStock = new StockMarket();

        Observer mobileClient = new MobileApp();
        Observer webClient = new WebApp();

        techStock.register(mobileClient);
        techStock.register(webClient);

        System.out.println("Market Update 1:");
        techStock.setPrice(150.50);

        System.out.println("\nMarket Update 2:");
        techStock.setPrice(155.00);
    }
}
