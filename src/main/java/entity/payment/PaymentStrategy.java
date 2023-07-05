package entity.payment;

import entity.payment.context.order.PayOrderContext;
import entity.payment.context.transaction.PaymentTransactionContext;

public abstract class PaymentStrategy {
    PayOrderContext payOrderContext;
    PaymentTransactionContext paymentTransactionContext;

    public PaymentStrategy(){

    }

    public void order(){
        payOrderContext.payOrder();
    }

    public void setInfo(){

    }

    public void setPayOrderContext(PayOrderContext po){
        payOrderContext = po;
    }

    public void setPaymentTransactionContext(PaymentTransactionContext pt){
        paymentTransactionContext = pt;
    }
}
