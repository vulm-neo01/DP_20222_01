package entity.payment;

public class PaymentTransaction {
	private String errorCode;
	// SOLID_OCP: Tương tự CreditCard, khó mở rộng khi thêm các hình thức thanh toán khác
	private CreditCard card;
	// Vi phạm DIP do PaymentTransaction đang phụ thuộc trực tiếp vào lớp CreditCard để tạo ra card
	// Trong trường hợp muốn thay đổi hay mở rộng nhiều phương thức thanh toán hơn sẽ là không thể.
	// Tạo một interface PaymentMethod, CreditCard hay các loại Card khác sẽ implements nó
	// Trong PaymentTransaction chỉ cần set loại payment và sử dụng.
	private String transactionId;
	private String transactionContent;
	private int amount;
	private String createdAt;
	
	public PaymentTransaction(String errorCode, CreditCard card, String transactionId, String transactionContent,
                              int amount, String createdAt) {
		super();
		this.errorCode = errorCode;
		this.card = card;
		this.transactionId = transactionId;
		this.transactionContent = transactionContent;
		this.amount = amount;
		this.createdAt = createdAt;
	}
	
	public String getErrorCode() {
		return errorCode;
	}
}
