package controller.PaymentController;

import java.util.Map;

public class Client {
    private PaymentController paymentController = new PaymentController(new PayOrderByCreditCard());
    paymentController.setPaymentStrategy(new PayOrderByCreditMomo());
    paymentController.payOrder();
}
