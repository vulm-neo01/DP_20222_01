package entity.cart;

import entity.media.Media;

public class CartItem {
    
    private Media media;
    // Có dấu hiệu vi phạm DIP tại đây. Do CartItem sử dụng trực tiếp Media
    // Để chỉnh sửa trường hợp này, có thể đơn giản biến Media thành abstract class
    // Khi này CartItem không phụ thuộc trực tiếp vào Media mà phụ thuộc vào abstract của nó.
    private int quantity;
    private int price;

    public CartItem(){

    }

    public CartItem(Media media, Cart cart, int quantity, int price) {
        this.media = media;
        this.quantity = quantity;
        this.price = price;
    }
    
    public Media getMedia() {
        return this.media;
    }

    public void setMedia(Media media) {
        this.media = media;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "{" 
            + " media='" + media + "'" 
            + ", quantity='" + quantity + "'" 
            + "}";
    }

}

    
