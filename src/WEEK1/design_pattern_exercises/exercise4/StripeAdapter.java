package WEEK1.design_pattern_exercises.exercise4;

class StripeAdapter implements PaymentProcessor {
    private StripeGateway gateway;

    public StripeAdapter(StripeGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public void processPayment(double amount) {
        gateway.makePayment(amount);
    }
}