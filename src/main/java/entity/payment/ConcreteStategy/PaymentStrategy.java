package entity.payment.ConcreteStategy;

import controller.BaseController;
import entity.payment.context.PayOrderContext;

import java.util.Map;

public abstract class PaymentStrategy extends BaseController {
    PayOrderContext payOrderContext;
    private String contents;
    private int amount;

    public PaymentStrategy(){

    }

    public abstract Map<String, String> order();

    public void setPayOrderContext(PayOrderContext po){
        payOrderContext = po;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
