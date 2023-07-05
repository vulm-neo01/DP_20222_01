package entity.payment.context;

import entity.payment.ConcreteStategy.PaymentStrategy;

public class OrderByEWallet implements PayOrderContext{

    @Override
    public void payOrder(PaymentStrategy paymentStrategy, int amount, String contents) {

    }
}
