package WEEK1.design_pattern_exercises.exercise8;

class PayPalPayment implements PaymentStrategy {
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using PayPal.");
    }
}
