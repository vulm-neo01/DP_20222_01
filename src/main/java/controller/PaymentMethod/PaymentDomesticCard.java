package controller.PaymentMethod;

import common.exception.PaymentException;
import common.exception.UnrecognizedException;
import entity.payment.CreditCard;
import entity.payment.DomesticCard;
import entity.payment.PaymentCard;
import entity.payment.PaymentTransaction;
import subsystem.InterbankSubsystem;

import java.util.Hashtable;
import java.util.Map;

public class PaymentDomesticCard extends PaymentMethod{

    @Override()
    public Map<String, String> payOrder(int amount, String contents, PaymentCard card){
        Map<String, String> result = new Hashtable<String, String>();
        result.put("RESULT", "PAYMENT FAILED!");
        try {
            PaymentCard creditCard = new DomesticCard(
                    card.cardInfo().get("cardCode"),
                    card.cardInfo().get("owner"),
                    super.getExpirationDate(card.cardInfo().get("dateExpired")),
                    Integer.parseInt(card.cardInfo().get("cvvCode"))
            );

            super.interbank = new InterbankSubsystem();
            PaymentTransaction transaction = interbank.payOrder(creditCard, amount, contents);

            result.put("RESULT", "PAYMENT SUCCESSFUL!");
            result.put("MESSAGE", "You have successfully paid the order!");
        } catch (PaymentException | UnrecognizedException ex) {
            result.put("MESSAGE", ex.getMessage());
        }
        return result;
    };
}
