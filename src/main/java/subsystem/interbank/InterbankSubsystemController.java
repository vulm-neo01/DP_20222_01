package subsystem.interbank;

import entity.payment.CreditCard;
import entity.payment.ConcreteStategy.PaymentStrategy;
import entity.payment.PaymentTransaction;

public class InterbankSubsystemController {

	private static InterbankPayloadConverter interbankPayloadConverter = new InterbankPayloadConverter();
	private static InterbankBoundary interbankBoundary = new InterbankBoundary();

	public PaymentTransaction refund(PaymentStrategy payment, int amount, String contents) {
		return null;
	}

	public PaymentTransaction payOrder(PaymentStrategy payment, int amount, String contents) {
		String requestPayload = interbankPayloadConverter.convertToRequestPayload(payment, amount, contents);
		String responseText = interbankBoundary.query(InterbankConfigs.PROCESS_TRANSACTION_URL, requestPayload);
		return interbankPayloadConverter.extractPaymentTransaction(responseText);
	}

}
