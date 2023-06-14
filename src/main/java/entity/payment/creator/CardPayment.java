package entity.payment.creator;

import common.exception.PaymentException;
import common.exception.UnrecognizedException;
import entity.payment.PaymentTransaction;
import entity.payment.product.CreditCard;
import entity.payment.product.DebitCard;
import entity.payment.product.Card;
import entity.payment.product.PrepaidCard;
import subsystem.InterbankInterface;
import subsystem.InterbankSubsystem;

import java.util.Hashtable;
import java.util.Map;

public class CardPayment{
    Card card;
    public Card chooseCard(String payment, int amount, String contents, String cardNumber, String cardHolderName,
                           String expirationDate, String securityCode, String issueBank, String validDate){
        if(payment.equals("DebitCard")){
            card = new DebitCard(cardNumber, cardHolderName, issueBank, validDate);
        } else if(payment.equals("CreditCard")){
            card = new CreditCard(cardNumber, cardHolderName, expirationDate, Integer.parseInt(securityCode));
        } else if (payment.equals("PrepaidCard")) {
            card = new PrepaidCard();
        }
        return card;
    }

}
