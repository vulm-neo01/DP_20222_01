package common.interfaces;

/**
 * @author
 */

//Phương thức update(Observable observable) trong interface Observer được sử dụng trong view > screen > home. Hơn nữa nó chỉ có 1 method
//=> KHÔNG bi phạm ISP
public interface Observer {

    void update(Observable observable);

}
