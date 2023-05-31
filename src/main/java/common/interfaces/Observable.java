package common.interfaces;

/**
 * @author
 */
public interface Observable {
    // Đây là Observer Pattern. Tuy nhiên xem xét ở điểm nào đó có thể nhận thấy có các đặc điểm của
    // Template Pattern. Khi mà các class con có thể kế thừa và triển khai các phương thức của mình.
    // Tuy nhiên đây vẫn là Observer Pattern

    void attach(Observer observer);
    void remove(Observer observer);
    void notifyObservers();

}
