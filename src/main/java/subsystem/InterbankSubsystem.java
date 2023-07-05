package subsystem;

import entity.payment.CreditCard;
import entity.payment.ConcreteStategy.PaymentStrategy;
import entity.payment.PaymentTransaction;
import subsystem.interbank.InterbankSubsystemController;

/***
 * The {@code InterbankSubsystem} class is used to communicate with the
 * Interbank to make transaction.
 * 
 * @author hieud
 *
 */
public class InterbankSubsystem implements InterbankInterface {

	/**
	 * Represent the controller of the subsystem
	 */
	private InterbankSubsystemController ctrl;

	/**
	 * Initializes a newly created {@code InterbankSubsystem} object so that it
	 * represents an Interbank subsystem.
	 */
	public InterbankSubsystem() {
		this.ctrl = new InterbankSubsystemController();
	}

	/**
	 * @see InterbankInterface#payOrder(PaymentStrategy, int,
	 *      String)
	 */
	public PaymentTransaction payOrder(PaymentStrategy payment, int amount, String contents) {
		PaymentTransaction transaction = ctrl.payOrder(payment, amount, contents);
		return transaction;
	}

	/**
	 * @see InterbankInterface#refund(PaymentStrategy, int,
	 *      String)
	 */
	public PaymentTransaction refund(PaymentStrategy payment, int amount, String contents) {
		PaymentTransaction transaction = ctrl.refund(payment, amount, contents);
		return transaction;
	}
}
