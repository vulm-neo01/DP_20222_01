package entity.payment.context;

import entity.payment.ConcreteStategy.PaymentStrategy;

public interface PayOrderContext {
    public void payOrder(PaymentStrategy paymentStrategy, int amount, String contents);
}
