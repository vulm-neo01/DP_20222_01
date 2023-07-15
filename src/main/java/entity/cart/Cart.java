package entity.cart;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.exception.MediaNotAvailableException;
import entity.media.Media;

// SOLID_SRP: vi phạm SRP do lớp cart có  nhiều nhiệm vụ vừa phải quản lý giỏ hàng vừa phải quản lý tính toàn. do vật có thê tác lớp cart thành 2 lớp
        // lớp quản lý giỏ hàng và lớp riêng để tính toán giỏ hàng, các phương thức để quản lý giỏ hàng như addCartMedia, removeCartMedia, emptyCart và
        // các phương thức để tính toán và trả về giá trị liên quan đến giỏ hàng như getTotalMedia, calSubtotal, checkAvailabilityOfProduct, checkMediaInCart.
public class Cart {
    //SOLID_SRP : VỪa phải quản lý giỏ hàng vừa có phương thức tính toán, và check tồn lại đợn hàng

    private List<CartItem> lstCartItem;

    public Cart() {
        lstCartItem = new ArrayList<>();
    }

    public void addCartMedia(CartItem cm){
        lstCartItem.add(cm);
    }

    public void removeCartMedia(CartItem cm){
        lstCartItem.remove(cm);
    }

    public List getListMedia(){
        return lstCartItem;
    }

    public void emptyCart(){
        lstCartItem.clear();
    }

    public int getTotalMedia(){
        int total = 0;
        for (Object obj : lstCartItem) {
            CartItem cm = (CartItem) obj;
            total += cm.getQuantity();
        }
        return total;
    }

    public int calSubtotal(){
        int total = 0;
        for (Object obj : lstCartItem) {
            CartItem cm = (CartItem) obj;
            total += cm.getPrice()*cm.getQuantity();
        }
        return total;
    }

    public void checkAvailabilityOfProduct() throws SQLException{
        boolean allAvailable = true;
        for (Object object : lstCartItem) {
            CartItem cartItem = (CartItem) object;
            int requiredQuantity = cartItem.getQuantity();
            int availQuantity = cartItem.getMedia().getQuantity();
            if (requiredQuantity > availQuantity) allAvailable = false;
        }
        if (!allAvailable) throw new MediaNotAvailableException("Some media not available");
    }

    public CartItem checkMediaInCart(Media media){
        for (CartItem cartItem : lstCartItem) {
            if (cartItem.getMedia().getId() == media.getId()) return cartItem;
        }
        return null;
    }

}
