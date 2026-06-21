package WEEK1.DesignPatterns.exercise4;

public class AdapterTest {
    public static void main(String[] args) {
        StripeGateway externalGateway = new StripeGateway();
        PaymentProcessor processor = new StripeAdapter(externalGateway);

        processor.processPayment(250.0);
    }
}
