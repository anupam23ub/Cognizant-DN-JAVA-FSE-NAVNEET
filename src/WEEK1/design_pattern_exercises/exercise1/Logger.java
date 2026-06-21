package WEEK1.design_pattern_exercises.exercise1;

class Logger {
    // Private static instance of the class
    private static Logger instance;

    // Private constructor to prevent instantiation
    private Logger() {
        System.out.println("Logger initialized.");
    }

    // Public static method to get the instance
    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void log(String message) {
        System.out.println("[LOG]: " + message);
    }
}
