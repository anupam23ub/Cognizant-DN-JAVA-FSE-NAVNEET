package WEEK1.design_pattern_exercises.exercise4;

class StripeGateway {
    public void makePayment(double amount) {
        System.out.println("Processing $" + amount + " through Stripe.");
    }
}