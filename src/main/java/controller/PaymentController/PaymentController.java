package controller.PaymentController;

import java.util.Map;

public class PaymentController {
    private PaymentStrategy paymentStrategy;

    public PaymentController(PaymentStrategy paymentStrategy){
        this.paymentStrategy = paymentStrategy;
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy){
        this.paymentStrategy = paymentStrategy;
    }

    public Map<String, String> payOrder(int amount, String contents, String cardNumber, String cardHolderName,
			String expirationDate, String securityCode){
        return paymentStrategy.payOrder( amount, contents, cardNumber, cardHolderName, expirationDate, securityCode);
    }
}
