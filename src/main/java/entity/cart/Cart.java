package entity.cart;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.exception.MediaNotAvailableException;
import entity.media.Media;

public class Cart {
    
    private List<CartItem> lstCartItem;

    public Cart() {
        lstCartItem = new ArrayList<>();
    }
    //có data coupling do lớp Cart có dử dụng dữ liệu của lớp CartItem để thêm một đối tượng từ danh sách
    public void addCartMedia(CartItem cm){
        lstCartItem.add(cm);
    }
    //có data coupling do lớp Cart có dử dụng dữ liệu của lớp CartItem để xoá một đối tượng từ danh sách
    public void removeCartMedia(CartItem cm){
        lstCartItem.remove(cm);
    }

    public List getListMedia(){
        return lstCartItem;
    }

    public void emptyCart(){
        lstCartItem.clear();
    }
    // có data coupling do 2 lớp tương tác với nhau quan dữ liệu của quantity
    public int getTotalMedia(){
        int total = 0;
        for (Object obj : lstCartItem) {
            CartItem cm = (CartItem) obj;
            total += cm.getQuantity();
        }
        return total;
    }
    // có data coupling do 2 lớp tương tác với nhau quan dữ liệu của quantity
    // có comminicational cohesion do phương thức tính tống tiền các mặt hàng trong giỏ hàng là không cần thiết,
    // việc tính tống tiền chỉ cần có mặt tại khi thanh toán là được
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
    // Stamp Coupling: Chỉ cần truyền vào media ID
    public CartItem checkMediaInCart(Media media){
        for (CartItem cartItem : lstCartItem) {
            if (cartItem.getMedia().getId() == media.getId()) return cartItem;
        }
        return null;
    }

}
