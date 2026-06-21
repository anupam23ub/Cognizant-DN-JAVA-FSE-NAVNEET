package WEEK1.design_pattern_exercises.exercise8;

public class StrategyTest {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();

        context.setPaymentStrategy(new CreditCardPayment());
        context.executePayment(89.99);

        context.setPaymentStrategy(new PayPalPayment());
        context.executePayment(25.50);
    }
}
