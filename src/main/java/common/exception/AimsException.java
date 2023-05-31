package common.exception;;

/**
 * The AimsException wraps all unchecked exceptions You can use this
 * exception to inform
 * 
 * @author nguyenlm
 */
public class AimsException extends RuntimeException {
	// Ở đây nên đổi thành abstract class vì có rất nhiều lớp đang kế thừa trực tiếp Exception này.
	// Việc đổi thành abstract class sẽ đúng với Template method Pattern
	// Điều này sẽ giúp code dễ tái sử dụng, dễ mở rộng và giảm sự phức tạp
    public AimsException() {

	}

	public AimsException(String message) {
		super(message);
	}
}