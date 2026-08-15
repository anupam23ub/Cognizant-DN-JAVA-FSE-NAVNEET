package WEEK1.DesignPatterns.exercise4;

class StripeGateway {
    public void makePayment(double amount) {
        System.out.println("Processing $" + amount + " through Stripe.");
    }
}