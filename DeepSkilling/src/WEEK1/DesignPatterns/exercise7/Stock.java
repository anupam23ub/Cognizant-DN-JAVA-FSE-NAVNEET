package WEEK1.DesignPatterns.exercise7;

interface Stock {
    void register(Observer o);
    void deregister(Observer o);
    void notifyObservers();
}
