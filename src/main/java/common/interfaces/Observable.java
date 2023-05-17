package common.interfaces;

/**
 * @author
 */

// Interface Observable có 3 phương thức attach(Observer observer), remove(Observer observer),  notifyObservers() đều được sử dụng trong views > home > Mediahandler
// => KHÔNG vi phạm ISP
public interface Observable {

    void attach(Observer observer);
    void remove(Observer observer);
    void notifyObservers();

}
