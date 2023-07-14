package controller;

import java.sql.SQLException;

import entity.cart.Cart;

/**
 * This class controls the flow of events when users view the Cart
 * @author nguyenlm
 */
//Communicational Cohesion vì chúng đều sử dụng dữ liệu trong entity cart
public class ViewCartController extends BaseController{
    
    /**
     * This method checks the available products in Cart
     * @throws SQLException
     */
    public void checkAvailabilityOfProduct() throws SQLException{
        //***common coupling
        // content-coupling
        SessionInformation.cartInstance.checkAvailabilityOfProduct();
    }

    /**
     * This method calculates the cart subtotal
     * @return subtotal
     */
    public int getCartSubtotal(){
        //***common coupling
        // content-coupling
        int subtotal = SessionInformation.cartInstance.calSubtotal();
        return subtotal;
    }

}
