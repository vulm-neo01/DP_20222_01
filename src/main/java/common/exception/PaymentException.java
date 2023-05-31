package common.exception;;

public class PaymentException extends RuntimeException {
	// Ở đây nên đổi thành abstract class vì có rất nhiều lớp đang kế thừa trực tiếp Exception này.
	// Việc đổi thành abstract class sẽ đúng với Template method Pattern
	// Điều này sẽ giúp code dễ tái sử dụng, dễ mở rộng và giảm sự phức tạp
	public PaymentException(String message) {
		super(message);
	}
}
