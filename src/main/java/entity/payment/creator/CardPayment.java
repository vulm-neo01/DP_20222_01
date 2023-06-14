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
    InterbankInterface interbank;
    Card chooseMethod(String type) {
        if(type.equals("DebitCard")){
            card = new DebitCard();
        } else if(type.equals("CreditCard")){
            card = new CreditCard();
        } else if(type.equals("PrepaidCard")){
            card = new PrepaidCard();
        }
        return card;
    }

}
