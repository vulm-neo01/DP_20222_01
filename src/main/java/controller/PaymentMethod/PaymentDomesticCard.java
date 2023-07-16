package controller.PaymentMethod;

import common.exception.PaymentException;
import common.exception.UnrecognizedException;
import entity.payment.CreditCard;
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
            PaymentCard creditCard = new CreditCard(
                    card.toTransactionMap().get("cardCode"),
                    card.toTransactionMap().get("owner"),
                    super.getExpirationDate(card.toTransactionMap().get("dateExpired")),
                    Integer.parseInt(card.toTransactionMap().get("cvvCode"))
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
