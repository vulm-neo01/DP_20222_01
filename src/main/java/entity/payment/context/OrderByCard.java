package entity.payment.context;

import entity.payment.ConcreteStategy.PaymentStrategy;
import entity.payment.PaymentTransaction;
import subsystem.InterbankInterface;
import subsystem.InterbankSubsystem;

public class OrderByCard implements PayOrderContext{
    InterbankInterface interbank;

    @Override
    public void payOrder(PaymentStrategy paymentStrategy, int amount, String contents) {
        this.interbank = new InterbankSubsystem();
        PaymentTransaction transaction = interbank.payOrder(paymentStrategy, amount, contents);
    }
}
