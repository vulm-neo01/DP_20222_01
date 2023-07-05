package entity.payment;

import entity.payment.ConcreteStategy.PaymentStrategy;

public class PaymentTransaction {
	private String errorCode;
	private PaymentStrategy payment;
	private String transactionId;
	private String transactionContent;
	private int amount;
	private String createdAt;
	
	public PaymentTransaction(String errorCode, PaymentStrategy payment, String transactionId, String transactionContent,
                              int amount, String createdAt) {
		super();
		this.errorCode = errorCode;
		this.payment = payment;
		this.transactionId = transactionId;
		this.transactionContent = transactionContent;
		this.amount = amount;
		this.createdAt = createdAt;
	}
	
	public String getErrorCode() {
		return errorCode;
	}
}
