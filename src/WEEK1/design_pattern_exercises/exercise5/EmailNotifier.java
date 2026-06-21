package WEEK1.design_pattern_exercises.exercise5;

class EmailNotifier implements Notifier {
    public void send(String message) {
        System.out.println("Sending Email: " + message);
    }
}
