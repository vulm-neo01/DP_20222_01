package entity.invoice;

import entity.order.Order;

public class Invoice {

    private Order order;
    // Vi phạm DIP, ở đây nên tạo thêm một OrderAbstract để Order extends nó.
    // Khi này trong Invoice sẽ không phụ thuộc trực tiếp vào Order mà sẽ gọi đến OrderAbstract
    private int amount;
    
    public Invoice(){

    }

    public Invoice(Order order){
        this.order = order;
        this.amount = order.getTotal();
    }

    public Order getOrder() {
        return order;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void saveInvoice(){
        
    }
}
