package controller;

import entity.cart.Cart;
import entity.user.User;

import java.time.LocalDateTime;

/**
 * @author
 */
public class SessionInformation {
    public static User mainUser;
    public static Cart cartInstance = new Cart();
    public static LocalDateTime expiredTime;
    // Không có getter, setter tại đây. Dẫn đến những Class khác khi gọi đến cần truy cập trực tiếp
    // vào thông tin của biến.
}
