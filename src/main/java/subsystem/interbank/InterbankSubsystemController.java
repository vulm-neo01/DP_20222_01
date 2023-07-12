package subsystem.interbank;

import entity.payment.CreditCard;
import entity.payment.PaymentTransaction;

public class InterbankSubsystemController {

	// Để tuân thủ DIP, có thể tạo các interface PayloadConverter và Boundary để InterbankPayloadConverter,
	// và InterbankBoundary implements.
	// Vậy thì trong class chỉ cần phụ thuộc vào abstract của chúng
	private static InterbankPayloadConverter interbankPayloadConverter = new InterbankPayloadConverter();
	private static InterbankBoundary interbankBoundary = new InterbankBoundary();

	// PaymentTransaction cũng tương tự như đã nói, tạo ra một abstract mới.
	public PaymentTransaction refund(CreditCard card, int amount, String contents) {
		return null;
	}

	public PaymentTransaction payOrder(CreditCard card, int amount, String contents) {
		String requestPayload = interbankPayloadConverter.convertToRequestPayload(card, amount, contents);
		String responseText = interbankBoundary.query(InterbankConfigs.PROCESS_TRANSACTION_URL, requestPayload);
		return interbankPayloadConverter.extractPaymentTransaction(responseText);
	}

}
