package WEEK1.DesignPatterns.exercise4;

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