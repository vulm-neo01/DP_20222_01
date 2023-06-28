package controller.PaymentController;

import java.util.Hashtable;
import java.util.Map;

public abstract class PaymentStrategy {
    public abstract Map<String, String> payOrder(int amount, String contents, String cardNumber, String cardHolderName,
			String expirationDate, String securityCode);
}
