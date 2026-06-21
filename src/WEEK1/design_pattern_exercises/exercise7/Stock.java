package WEEK1.design_pattern_exercises.exercise7;

interface Stock {
    void register(Observer o);
    void deregister(Observer o);
    void notifyObservers();
}
