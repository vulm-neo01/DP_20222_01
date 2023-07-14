package entity.cart;

import entity.media.Media;

public class CartItem {
    
    private Media media;
    private int quantity;
    private int price;

    public CartItem(){

    }
    // Stamp coupling: cart
    public CartItem(Media media, Cart cart, int quantity, int price) {
        this.media = media;
        this.quantity = quantity;
        this.price = price;
    }
    // đoạn code này có Communicational cohesion do tất cả các phương thức getter chi cùng thao tác trên một cơ sở dữ liệu, chúng không có liên quan các tính năng với nhau
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

    
