package common.interfaces;

/**
 * @author
 */
public interface Observable {
    // Đây là Observer Pattern, không phải Template Method

    void attach(Observer observer);
    void remove(Observer observer);
    void notifyObservers();

}
