package WEEK1.design_pattern_exercises.exercise5;

public class DecoratorTest {
    public static void main(String[] args) {
        Notifier emailNotifier = new EmailNotifier();

        Notifier multiChannelNotifier = new SlackNotifierDecorator(new SMSNotifierDecorator(emailNotifier));

        System.out.println("Triggering critical alert...");
        multiChannelNotifier.send("Server is down!");
    }
}
