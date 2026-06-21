package WEEK1.design_pattern_exercises.exercise1;

public class SingletonTest {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        logger1.log("First log entry.");

        Logger logger2 = Logger.getInstance();
        logger2.log("Second log entry.");

        System.out.println("Are both instances the same? " + (logger1 == logger2));
    }
}
