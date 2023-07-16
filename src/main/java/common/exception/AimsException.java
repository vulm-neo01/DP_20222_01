package common.exception;;

/**
 * The AimsException wraps all unchecked exceptions You can use this
 * exception to inform
 * 
 * @author nguyenlm
 */
public class AimsException extends RuntimeException {
	// Không phải Template Method => Suy nghĩ lại
    public AimsException() {

	}

	public AimsException(String message) {
		super(message);
	}
}