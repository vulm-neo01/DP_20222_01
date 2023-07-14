package entity.order;

import controller.SessionInformation;
import entity.cart.Cart;
import entity.cart.CartItem;
import entity.shipping.DeliveryInfo;
import views.screen.ViewsConfig;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Order {

    private int shippingFees;
    private int subtotal;
    private int tax;
    private List orderMediaList;
    protected DeliveryInfo deliveryInfo;
    // lớp này có functional cohesion do các phương thức có liên quan đến nhau, chúng t=cùng thực hiện một nhiện vụ thieest lập cho lớp
    public Order() {
        this.shippingFees = 0;
        this.subtotal = 0;
        this.tax = 0;
    }
    //Stamp coupling: cart
    public Order(Cart cart) {
        List<OrderItem> orderItems = new ArrayList<>();
        //***common coupling
        for (Object object : SessionInformation.cartInstance.getListMedia()) {
            // Vi phạm Content coupling do truy cập trực tiếp method. Điều này khiến cho
            // Order phụ thuộc trực tiếp vào SessionInformation class và Cart class.
            CartItem cartItem = (CartItem) object;
            OrderItem orderItem = new OrderItem(cartItem.getMedia(),
                    cartItem.getQuantity(),
                    cartItem.getPrice());
            orderItems.add(orderItem);
        }
        this.orderMediaList = Collections.unmodifiableList(orderItems);
        this.subtotal = cart.calSubtotal();
        this.tax = (int) (ViewsConfig.PERCENT_VAT/100) * subtotal;   //***common coupling
    }

    public List getListOrderMedia() {
        return this.orderMediaList;
    }

    public int getShippingFees() {
        if (deliveryInfo == null) return 0;
        return this.shippingFees;
    }

    public DeliveryInfo getDeliveryInfo() {
        return deliveryInfo;
    }

    public void setDeliveryInfo(DeliveryInfo deliveryInfo) {
        this.deliveryInfo = deliveryInfo;
        this.shippingFees = deliveryInfo.calculateShippingFee(this);
    }

    public List getOrderMediaList() {
        return orderMediaList;
    }

    public int getSubtotal() {
        return subtotal;
    }

    public int getTax() {
        return tax;
    }

    public int getTotal() {
        return this.subtotal + this.tax + this.shippingFees;
    }
}
