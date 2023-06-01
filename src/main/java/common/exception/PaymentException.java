package common.exception;;

public class PaymentException extends RuntimeException {
	// Không phải Template Method => Suy nghĩ lại
	public PaymentException(String message) {
		super(message);
	}
}
