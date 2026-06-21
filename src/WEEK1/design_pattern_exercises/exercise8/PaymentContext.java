package WEEK1.design_pattern_exercises.exercise8;

class PaymentContext {
    private PaymentStrategy strategy;

    public void setPaymentStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void executePayment(double amount) {
        if (strategy == null) {
            System.out.println("No payment strategy selected.");
            return;
        }
        strategy.pay(amount);
    }
}
