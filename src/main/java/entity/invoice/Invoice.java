package entity.invoice;

import entity.order.Order;

public class Invoice {

    private Order order;
    private int amount;
    
    public Invoice(){

    }
    //có data coupling do 2 class Invoice và Order tương tác với nhau thông qua dữ liệu total
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
