package WEEK1.DesignPatterns.exercise5;

class SlackNotifierDecorator extends NotifierDecorator {
    public SlackNotifierDecorator(Notifier notifier) { super(notifier); }

    public void send(String message) {
        super.send(message);
        System.out.println("Sending Slack message: " + message);
    }
}
